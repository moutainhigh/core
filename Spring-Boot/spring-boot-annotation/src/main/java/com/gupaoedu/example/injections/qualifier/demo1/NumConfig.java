package com.gupaoedu.example.injections.qualifier.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/3 13:19
 * @Version:1.0
 */
@Configuration
public class NumConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumConfig.class);

    // �������ע�͵�  @Qualifierע�⣬������֤
    @Bean
    @Qualifier
    public NumBean numBean1() {
        LOGGER.info("numBean1");
        return new NumBean("����", 47);
    }

    @Bean
    @Qualifier
    public NumBean numBean2() {
        LOGGER.info("numBean2");
        return new NumBean("����", 29);
    }
}
