package com.gupaoedu.example.condition.conditionalonbean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/2 12:28
 * @Version:1.0
 */
@SpringBootApplication
public class TestConditionOn {

    public static void main(String[] args) {
        // 基于注解形式的启动
        AnnotationConfigApplicationContext acp =
                new AnnotationConfigApplicationContext(TestConditionOn.class);

        People people = acp.getBean(People.class);
        System.out.println("= = = = = = = = = = = = = ");
        System.out.println("people = " + people);
        System.out.println("= = = = = = = = = = = = = ");
    }
}
