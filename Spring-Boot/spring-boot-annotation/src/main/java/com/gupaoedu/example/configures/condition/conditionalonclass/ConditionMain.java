package com.gupaoedu.example.configures.condition.conditionalonclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/2 10:02
 * @Version:1.0
 */
@SpringBootApplication
public class ConditionMain {

    private static Logger LOGGER  = LoggerFactory.getLogger(ConditionMain.class);

    public static void main(String[] args) {
        // 基于注解形式的启动
        AnnotationConfigApplicationContext acp =
                new AnnotationConfigApplicationContext(ConditionMain.class);

        BeanClass bean = acp.getBean(BeanClass.class);
        LOGGER.info(bean.toString());
        bean.print();

        LOGGER.info(acp.getBean(Billy.class).fight());
    }
}
