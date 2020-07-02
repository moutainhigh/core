package com.gupaoedu.example.jmxdemo;

/**
 * 接口的实现类名称去掉MBean
 **/
public class SystemInfo implements SystemInfoMBean {

    // 获取cpu核数
    @Override
    public int getCpuCore() {
        return Runtime.getRuntime().availableProcessors();
    }

    // 获取总内存
    @Override
    public long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    // 关机
    @Override
    public void shutdown() {
        System.exit(0);
    }
}
