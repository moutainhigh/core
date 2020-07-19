package com.gupaoedu.environment.profiledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 通过@Profile注解实现针对bean的配置进行逻辑分组
 **/
@Configuration
public class ProfileConfiguration {

	// 表示不同环境  但是使用方式最多的是application-pro.yml这种方式
    @Profile("dev")
    @Bean
    public ProfileService profileServiceDev(){
        return new ProfileService("dev");
    }

    @Profile("prd")
    @Bean
    public ProfileService profileServicePrd(){
        return new ProfileService("prd");
    }
}
