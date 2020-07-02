package com.gupaoedu.example.condition.conditionalonclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

/**
 * ConditionalOnClass 条件装配
 * 当在classpath路径下存在BeanClass类时，对ConditionClassConfig进行装配，装载到容器中
 *
 * @Author: fengleima  2020/7/2 9:59
 */
@ConditionalOnClass(BeanClass.class)
public class ConditionClassConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionClassConfig.class);

    @Bean
    public BeanClass beanclass() {
        LOGGER.info("BeanClass 装载完成");
        return new BeanClass();
    }
}
