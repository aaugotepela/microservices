package com.techprimers.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*@EnableDiscoveryClient is super class of @EnableEurekaClient*/
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class HelloZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloZuulServiceApplication.class, args);
	}

}

