package com.gupaoedu.book.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 在启动方法上加上@DubboComponentScan跟Spring Framework 提供的@ComponentScan作用一样，
 * 只不过这里扫描的是Dubbo中的@Service注解
 */
@DubboComponentScan
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        System.out.println("Service start...");
        SpringApplication.run(ProviderApplication.class, args);
    }
}
