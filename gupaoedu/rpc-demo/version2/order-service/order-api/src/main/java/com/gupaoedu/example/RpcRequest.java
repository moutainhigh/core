package com.gupaoedu.example;

import java.io.Serializable;

/**
 * 客户端请求的封装
 * http://www.gupaoedu.com
 **/
public class RpcRequest implements Serializable {

    // 反射方法的类
    private String className;
    // 反射调用的方法
    private String methodName;
    // 反射调用方法的参数 这里传递的是调用放传递的参数
    private Object[] args;
    // 反射调用方法参数的类型
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
