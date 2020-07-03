package com.gupaoedu.example.configures.configurationproperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableConfigurationProperties 作用：将配置文件类注册到IOC容器
 * 
 * @Author: fengleima  2020/7/2 14:49
 */
@Configuration
@EnableConfigurationProperties(ConfigBeanProp.class)
public class EnableBeanproperties {

}
