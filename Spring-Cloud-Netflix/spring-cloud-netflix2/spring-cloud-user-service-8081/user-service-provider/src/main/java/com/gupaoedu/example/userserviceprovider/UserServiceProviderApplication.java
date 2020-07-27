package com.gupaoedu.example.userserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;


@EnableCircuitBreaker
@ComponentScan(basePackages = {
        "com.gupaoedu.example.controller",
        "com.gupaoedu.example.sourceloader",
        "com.gupaoedu.example",
    "com.gupaoedu.springcloud.clients"})
@EnableFeignClients(basePackages = "com.gupaoedu.springcloud.clients")
@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {

//        ConfigurableApplicationContext context=SpringApplication.run(UserServiceProviderApplication.class, args);
        SpringApplication springApplication=new SpringApplication(UserServiceProviderApplication.class);
        Map<String,Object> map=new HashMap<>();
        map.put("key","value");
        springApplication.setDefaultProperties(map);
        springApplication.run(args);
    }

}
