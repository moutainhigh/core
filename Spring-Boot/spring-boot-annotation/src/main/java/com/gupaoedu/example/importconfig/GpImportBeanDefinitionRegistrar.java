package com.gupaoedu.example.importconfig;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportBeanDefinitionRegistrar的作用是Bean的动态装载
 * 定义一个ImportBeanDefinitionRegistrar的实现，装载到IOC容器
 **/
public class GpImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册Bean
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        // 设置Bean的名字
        beanDefinition.setBeanClassName(HelloService.class.getName());
        // 注册Bean
        registry.registerBeanDefinition("helloService", beanDefinition);
    }
}
