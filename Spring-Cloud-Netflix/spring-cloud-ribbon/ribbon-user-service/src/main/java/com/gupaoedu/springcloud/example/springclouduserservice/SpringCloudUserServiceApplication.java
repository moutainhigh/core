package com.gupaoedu.springcloud.example.springclouduserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gupaoedu")
@SpringBootApplication
public class SpringCloudUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserServiceApplication.class, args);
    }

}
