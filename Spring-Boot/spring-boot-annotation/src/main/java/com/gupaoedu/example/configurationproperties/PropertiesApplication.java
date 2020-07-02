package com.gupaoedu.example.configurationproperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/2 14:47
 * @Version:1.0
 */
@SpringBootApplication
public class PropertiesApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(PropertiesApplication.class, args);
        ConfigBeanProp bean = cac.getBean(ConfigBeanProp.class);
        LOGGER.info("读取配置文件属性 {}",bean.toString());

    }
}
