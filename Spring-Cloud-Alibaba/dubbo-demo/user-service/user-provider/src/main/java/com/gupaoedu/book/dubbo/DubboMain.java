package com.gupaoedu.book.dubbo;

import org.apache.dubbo.common.compiler.Compiler;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Dubbo启动
 * create-date: 2020/1/6-12:10
 */
public class DubboMain {

    public static void main(String[] args) throws IOException {
        // 启动第一种方式
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/user-provider.xml");
        context.start();
//        Compiler compiler = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
//        System.out.println(compiler.getClass());
        System.out.println("provider service start...");
        System.in.read(); //阻塞Main线程

        // 启动第二种方式 两种没有本质区别，只是Dubbo做了一层封装
        //Main.main(args);
    }
}
