package com.gupaoedu.example.importconfig;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportBeanDefinitionRegistrar��������Bean�Ķ�̬װ��
 * ����һ��ImportBeanDefinitionRegistrar��ʵ�֣�װ�ص�IOC����
 **/
public class GpImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * ע��Bean
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        // ����Bean������
        beanDefinition.setBeanClassName(HelloService.class.getName());
        // ע��Bean
        registry.registerBeanDefinition("helloService", beanDefinition);
    }
}
