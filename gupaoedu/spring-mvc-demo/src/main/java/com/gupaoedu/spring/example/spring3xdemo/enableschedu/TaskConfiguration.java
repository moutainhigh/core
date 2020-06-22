package com.gupaoedu.spring.example.spring3xdemo.enableschedu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring  3.x  Enable  模块驱动
 **/
@ComponentScan("com.gupaoedu.spring3xdemo.enableschedu")
@EnableScheduling // 启动定时任务模块
@Configuration
public class TaskConfiguration {

}
