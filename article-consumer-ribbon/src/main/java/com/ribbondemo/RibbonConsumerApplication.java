package com.ribbondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ribbondemo.controller.RibbonConsumerService;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonConsumerApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RibbonConsumerApplication.class, args);
		RibbonConsumerService consumerService = ctx.getBean(RibbonConsumerService.class);
		System.out.printf("######## Result of call producer is " + consumerService.callProducer() + " \n");
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
