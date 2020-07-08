package com.gupaoedu.springcloud.example.springclouduserservice;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 调整Feign的日志级别
 **/
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
