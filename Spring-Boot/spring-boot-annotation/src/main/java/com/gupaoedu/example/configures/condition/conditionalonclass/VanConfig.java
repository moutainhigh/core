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
     * 如果把Billy修改成Billy99，这classpath路径下不存在Billy99类，运行报错，证明
     *
     * @ConditionalOnClass注解作用是 当在classpath路径下存在某个类时，则对当前Bean进行装配，装载到容器中
     */
    @Bean
//    @ConditionalOnClass(Billy.class) // 这种方式使用跟下面name使用是一模一样
  @ConditionalOnClass(name = "com.gupaoedu.example.configures.condition.conditionalonclass.Billy")

//    @ConditionalOnClass(name = "com.gupaoedu.example.configures.condition.conditionalonclass.Billy99")
    public Billy billy() {
        LOGGER.info("Fighter 成功加载");
        return new Billy();
    }

}
