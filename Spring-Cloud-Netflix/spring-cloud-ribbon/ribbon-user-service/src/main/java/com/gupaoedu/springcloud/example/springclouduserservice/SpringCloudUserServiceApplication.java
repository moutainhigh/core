package com.gupaoedu.springcloud.example.springclouduserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@EnableFeignClients   // 默认扫描当前路径下的，开启feign的扫描
@ComponentScan(basePackages = "com.gupaoedu")
@SpringBootApplication
public class SpringCloudUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserServiceApplication.class, args);
    }

}
