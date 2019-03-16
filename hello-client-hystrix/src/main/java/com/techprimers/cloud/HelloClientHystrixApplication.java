package com.techprimers.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*@EnableHystrix is super set of EnableCircuitBreaker*/
//@EnableCircuitBreaker
@EnableHystrix
@SpringBootApplication
@EnableFeignClients
public class HelloClientHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloClientHystrixApplication.class, args);
	}

}



@Configuration
class Config {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}