package com.gupaoedu.example.injections.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 **/
@Configuration
public class QualifierConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(QualifierConfig.class);

    // 为什么这里要自定义注入的名称，因为有两个一模一样的类，如果不自定义名称，spring默认单例的，
    // 两个同样的类就不会再加载到容器，启动就会报错。
    @Bean("testClass1")
    TestClass testClass1(){
        LOGGER.info("TestClass1");
        return new TestClass("开帅1");
    }

    @Bean("testClass2")
    TestClass testClass2(){
        LOGGER.info("TestClass2 add @Qualifier");
        return new TestClass("忘性2");
    }

}
