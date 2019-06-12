package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrixDashboard
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
public class ZuulAggApplication {
    public static void main(String[] args) {
        SpringApplication.run( ZuulAggApplication.class, args );
    }
}
