package com.gupaoedu.example.configures.configurationproperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableConfigurationProperties ���ã��������ļ���ע�ᵽIOC����
 * 
 * @Author: fengleima  2020/7/2 14:49
 */
@Configuration
@EnableConfigurationProperties(ConfigBeanProp.class)  // @EnableConfigurationPropertiesע�����ã��Զ�����RedissonProperties����װ��
public class EnableBeanproperties {

}
