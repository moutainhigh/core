package com.gupaoedu.springcloud.example.springclouduserservice;

import com.gupaoedu.springcloud.example.demo02.EnableGpRegistrara;
import com.gupaoedu.springcloud.example.demo02.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableGpRegistrara // 开启自定义的注解
@EnableFeignClients(basePackages = "com.gupaoedu.example.clients")  // 开启Feign的扫描​
@SpringBootApplication
public class SpringCloudUserServiceApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext contxt = SpringApplication.run(SpringCloudUserServiceApplication.class, args);
        System.out.println(contxt.getBean(HelloService.class));
    }

}
