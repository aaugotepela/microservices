package com.techprimers.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    @GetMapping
    public String hello() {
        String url = "http://hello-server/rest/hello/server";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(Throwable hystrixCommand) {
    	System.out.println("Message:"+hystrixCommand.getMessage());
    	hystrixCommand.printStackTrace();
        return "Fall Back Hello world";
    }

}
