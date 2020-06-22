package com.gupaoedu.spring1xdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动入口
 **/
@Configuration
@ComponentScan("com.gupaoedu.spring1xdemo")//因为这里项目没有使用SpringBoot，而是spring项目，所以得配置自动扫描
public class Bootstrap {

    public static void main(String[] args) {
        System.out.println("Service start...");
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Bootstrap.class);
    }
}
