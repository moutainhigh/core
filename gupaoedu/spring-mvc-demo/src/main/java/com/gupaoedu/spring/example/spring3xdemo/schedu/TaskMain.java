package com.gupaoedu.spring.example.spring3xdemo.schedu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class TaskMain {

    public static void main(String[] args) {
        ApplicationContext context=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

    }
}
