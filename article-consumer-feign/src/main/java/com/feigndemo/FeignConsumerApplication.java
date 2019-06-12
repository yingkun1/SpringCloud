package com.feigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.feigndemo.controller.FeignConsumerService;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FeignConsumerApplication.class, args);
		FeignConsumerService consumerService = context.getBean(FeignConsumerService.class);
		System.out.printf("############# Result of call producer is " + consumerService.getAllArticles() + "\n");
	}
}