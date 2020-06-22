package com.gupaoedu.spring.example.spring3xdemo.otherconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 **/
@Configuration  // 配置文件
public class ImportConfiguration {

    @Bean  // 配置文件被spring管理的bean
    public ImportService importService(){
        return new ImportService();
    }
}
