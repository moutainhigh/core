package com.gupaoedu.autoconfiguration.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 条件装配有两种形式
 * 一种是 @ConditionalOnClass
 * 另外一种是在spring-autoconfigure-metadata.properties文件中进行配置
 * 在GupaoConfiguration后面加一个ConditionalOnClass，然后设置一个加载类
 *
 * 说明GupaoConfiguration加载的前提是有一个demoClass类
 * com.gupaoedu.autoconfiguration.demo.GupaoConfiguration.ConditionalOnClass=com.gupaoedu.example.DemoClass
 **/
/*@ConditionalOnClass({RedisOperations.class})*/

@Configuration
public class GupaoConfiguration {

    @Bean
    public GupaoEduCore gupaoEduCore() {
        return new GupaoEduCore();
    }
}
