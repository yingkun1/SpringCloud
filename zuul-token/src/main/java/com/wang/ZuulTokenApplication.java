package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
public class ZuulTokenApplication {
    public static void main(String[] args) {
        SpringApplication.run( ZuulTokenApplication.class, args );
    }
    
//    @Bean
//    public TokenFilter tokenFilter() {
//    	return new TokenFilter();
//    }
    
}
