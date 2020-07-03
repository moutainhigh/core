package com.gupaoedu.example.configures.condition.conditionalonclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fengleima  2020/7/2 13:35
 */
@Configuration
public class VanConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(VanConfig.class);

    /**
     * �����Billy�޸ĳ�Billy99����classpath·���²�����Billy99�࣬���б���֤��
     *
     * @ConditionalOnClassע�������� ����classpath·���´���ĳ����ʱ����Ե�ǰBean����װ�䣬װ�ص�������
     */
    @Bean
//    @ConditionalOnClass(Billy.class) // ���ַ�ʽʹ�ø�����nameʹ����һģһ��
  @ConditionalOnClass(name = "com.gupaoedu.example.configures.condition.conditionalonclass.Billy")

//    @ConditionalOnClass(name = "com.gupaoedu.example.configures.condition.conditionalonclass.Billy99")
    public Billy billy() {
        LOGGER.info("Fighter �ɹ�����");
        return new Billy();
    }

}
