package com.gupaoedu.example.userserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;


@EnableCircuitBreaker // 开启熔断
@ComponentScan(basePackages = {
        "com.gupaoedu.example.controller",
        "com.gupaoedu.example.config",
        "com.gupaoedu.example"})
@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(UserServiceProviderApplication.class);
        springApplication.run(args);
    }

}
