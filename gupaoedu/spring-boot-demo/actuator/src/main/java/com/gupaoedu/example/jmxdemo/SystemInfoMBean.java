package com.gupaoedu.example.jmxdemo;

/**
 * 接口的后缀是MBean  一定是一个接口，并且有一个实现类，
 * 接口的实现类名称去掉MBean
 * 接口方法中getXXX方法说明是属性的获取，没有get说明是操作
 **/
public interface SystemInfoMBean {

    int getCpuCore();

    long getTotalMemory();

    void shutdown();
}
