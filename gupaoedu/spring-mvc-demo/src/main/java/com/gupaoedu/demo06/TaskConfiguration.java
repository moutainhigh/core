package com.gupaoedu.demo06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring  3.x  Enable  模块驱动
 **/
@ComponentScan("com.gupaoedu.demo06")
@EnableScheduling // 启动完成定时任务的
@Configuration
public class TaskConfiguration {

}
