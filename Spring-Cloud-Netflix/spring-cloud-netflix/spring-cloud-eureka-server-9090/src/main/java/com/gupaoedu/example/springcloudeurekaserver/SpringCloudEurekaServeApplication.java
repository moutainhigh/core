package com.gupaoedu.example.springcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 开启eureka注册中心功能
@SpringBootApplication
public class SpringCloudEurekaServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServeApplication.class, args);
    }

}
