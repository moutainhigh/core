package com.gupaoedu.example.injections.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/3 12:29
 * @Version:1.0
 */
@SpringBootApplication
public class QualifierMain {
    private static Logger LOGGER = LoggerFactory.getLogger(QualifierMain.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac =
                new AnnotationConfigApplicationContext(QualifierMain.class);

        CusComponent bean = acac.getBean(CusComponent.class);
        bean.testQualifier();

    }
}
