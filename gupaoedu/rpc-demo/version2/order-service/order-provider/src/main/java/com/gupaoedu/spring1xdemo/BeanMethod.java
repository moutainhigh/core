package com.gupaoedu.spring1xdemo;

import java.lang.reflect.Method;

/**
 * 反射调用的信息
 * http://www.gupaoedu.com
 **/
public class BeanMethod {
    // 反射调用的类
    private Object bean;

    // 反射调用的方法
    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
