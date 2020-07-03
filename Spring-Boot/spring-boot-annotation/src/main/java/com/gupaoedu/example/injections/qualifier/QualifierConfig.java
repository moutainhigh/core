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

    // Ϊʲô����Ҫ�Զ���ע������ƣ���Ϊ������һģһ�����࣬������Զ������ƣ�springĬ�ϵ����ģ�
    // ����ͬ������Ͳ����ټ��ص������������ͻᱨ��
    @Bean("testClass1")
    TestClass testClass1(){
        LOGGER.info("TestClass1");
        return new TestClass("��˧1");
    }

    @Bean("testClass2")
    TestClass testClass2(){
        LOGGER.info("TestClass2 add @Qualifier");
        return new TestClass("����2");
    }

}
