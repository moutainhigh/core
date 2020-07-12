package com.gupaoedu.example.orderservice;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * Spring 容器加载完所有Bean并且初始化之后 调用所有SmartLifecycle的实现
 *
 * @Author: mafenglei @Date: 2020/7/12 10:28
 */
@Component // 注册到容器里面
public class TestSmartLifeCycle implements SmartLifecycle {
    @Override
    public void start() {
        System.out.println("======================start======================");
    }

    @Override
    public void stop() {
        System.out.println("======================stop======================");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
