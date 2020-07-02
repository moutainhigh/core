package com.gupaoedu.example.condition.conditionalonclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

/**
 * ConditionalOnClass ����װ��
 * ����classpath·���´���BeanClass��ʱ����ConditionClassConfig����װ�䣬װ�ص�������
 *
 * @Author: fengleima  2020/7/2 9:59
 */
@ConditionalOnClass(BeanClass.class)
public class ConditionClassConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionClassConfig.class);

    @Bean
    public BeanClass beanclass() {
        LOGGER.info("BeanClass װ�����");
        return new BeanClass();
    }
}
