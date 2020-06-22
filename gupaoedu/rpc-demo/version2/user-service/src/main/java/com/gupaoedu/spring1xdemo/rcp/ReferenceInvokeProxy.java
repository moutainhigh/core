package com.gupaoedu.spring1xdemo.rcp;

import com.gupaoedu.spring1xdemo.rcp.annotation.GpReference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * BeanPostProcessor的作用：  Spring IoC容器初始化受管Bean之前、属性设置之后对该Bean先做一些预处理和后处理
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Component
public class ReferenceInvokeProxy implements BeanPostProcessor{

    @Autowired
    RemoteInvocationHandler invocationHandler;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 得到类下的所有属性
        Field[] fields=bean.getClass().getDeclaredFields();
        for(Field field:fields){
            // 所有的属性只要是带有GpReference注解，就为其给一个代理
            if(field.isAnnotationPresent(GpReference.class)){
                // 暴力访问 (有些是private)
                field.setAccessible(true);
                //针对这个加了GpReference注解的字段，设置为一个代理的值
                Object proxy= Proxy.newProxyInstance(field.getType().getClassLoader(),new Class<?>[]{field.getType()},invocationHandler);
                try {
                    field.set(bean,proxy); //相当于针对加了GpReference的注解，设置了一个代理，这个代理的实现是inovcationHandler
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
