package com.gupaoedu.book.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动
 */
public class AppMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/consumer.xml");

        // 这里的IUserService返回的是一个代理对象，底层会基于网络通信来实现远程服务的调用
        IUserService iUserService = (IUserService) context.getBean("userService");
        System.out.println(iUserService.getNameById("ROW:2,page:10"));
    }
}
