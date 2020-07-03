package com.gupaoedu.example.configures.condition;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Titile: IntelliJ IDEA
 * @Description:
 * @Author: mafenglei @Date: 2020/6/26 16:39
 * @Version:1.0
 */
@SpringBootApplication
public class ConditionApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ca =
                new AnnotationConfigApplicationContext(ConditionConfig.class);
        System.out.println(ca.getBean(BeanDemo.class));
    }
}
