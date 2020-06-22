package com.gupaoedu.spring2xdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class Demo02Main {
    public static void main(String[] args) {

        // FileSystemXmlApplicationContext 为基于xml文件形式的去加载
        ApplicationContext context=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(context.getBean(Demo02Service.class));
    }
}
