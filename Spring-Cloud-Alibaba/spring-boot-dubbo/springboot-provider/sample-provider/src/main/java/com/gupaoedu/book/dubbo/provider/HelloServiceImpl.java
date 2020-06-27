package com.gupaoedu.book.dubbo.provider;

import com.gupaoedu.book.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * 注册发布服务  使用Dubbo提供的@Service注解发布服务
 * create-date: 2020/1/6-15:21
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        System.out.println("收到远程调用者的请求 name:" + name);
        String format = String.format("[%s]：Hello,%s", serviceName, name);
        return format;
    }
}
