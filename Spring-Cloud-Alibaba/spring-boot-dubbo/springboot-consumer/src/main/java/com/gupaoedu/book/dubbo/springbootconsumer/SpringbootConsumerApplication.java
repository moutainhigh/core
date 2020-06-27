package com.gupaoedu.book.dubbo.springbootconsumer;

import com.gupaoedu.book.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 使用Dubbo提供的Reference注解来获取一个远程代理对象
 */
@SpringBootApplication
public class SpringbootConsumerApplication {
//    @Reference(url = "dubbo://192.168.13.1:20880/com.gupaoedu.book.dubbo.IHelloService")
    @Reference(url = "dubbo://localhost:20880/com.gupaoedu.book.dubbo.IHelloService")
    private IHelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConsumerApplication.class, args);
    }
    @Bean
    public ApplicationRunner runner(){
        return args -> System.out.println("调用远程服务结果返回：" + helloService.sayHello("Mic"));
    }
}
