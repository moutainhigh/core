package com.gupaoedu.spring1xdemo.merdiator;

import com.gupaoedu.spring1xdemo.BeanMethod;
import com.gupaoedu.spring1xdemo.annotation.GpRemoteService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 初始化路由
 * BeanPostProcessor的作用：  Spring IoC容器初始化受管Bean之前、属性设置之后对该Bean先做一些预处理和后处理
 **/
@Component
public class InitialMerdiator implements BeanPostProcessor {

    /**
     * 每个Bean在收Spring IoC容器管理之前都会调用此方法   有几个bean 这里就会调用几次
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //加了服务发布标记GpRemoteService注解的bean进行远程发布
        if (bean.getClass().isAnnotationPresent(GpRemoteService.class)) {
            System.out.println("===============服务发布===============");
            // 获得当前类下面的 所有方法
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (Method method : methods) {
                // 获取方法所在类的接口声明
                String key = bean.getClass().getInterfaces()[0].getName() + "." + method.getName();

                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                System.out.println(key);

                // 存储发布的服务实例
                Mediator.map.put(key, beanMethod);
            }
            System.out.println("发布完成");
        }
        return bean;
    }
}
