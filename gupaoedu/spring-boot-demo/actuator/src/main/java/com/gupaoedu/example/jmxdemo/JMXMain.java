package com.gupaoedu.example.jmxdemo;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * 启动
 **/
public class JMXMain {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.gupaoedu.example:type=SystemInfo");
        SystemInfo systemInfo = new SystemInfo();
        mBeanServer.registerMBean(systemInfo, objectName);
        System.in.read();// 阻塞，防止程序运行结束
    }
}
