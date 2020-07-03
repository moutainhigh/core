package com.gupaoedu.example.injections.qualifier.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/3 13:25
 * @Version:1.0
 */
@SpringBootApplication
public class NumMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumMain.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac =
                new AnnotationConfigApplicationContext(NumMain.class);

        NumComponent component = acac.getBean(NumComponent.class);
        LOGGER.info(component.toString());
        LOGGER.info("验证结果：{}", component.test().toString());
    }

}
