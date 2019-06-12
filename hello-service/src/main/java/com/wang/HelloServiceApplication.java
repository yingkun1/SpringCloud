package com.wang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class HelloServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run( HelloServiceApplication.class, args );
    }

    @Value("${server.port}")
    String port;
    
    @Value("${hello}")
    String hello;

    @RequestMapping("/hello")
    public String home(@RequestParam(value = "name", defaultValue = "wang") String name) {
        return "hello " + name + " ,i am from port:" + port + hello;
    }
}
