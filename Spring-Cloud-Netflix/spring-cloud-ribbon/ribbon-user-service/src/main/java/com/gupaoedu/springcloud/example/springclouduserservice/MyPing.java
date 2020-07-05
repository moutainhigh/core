package com.gupaoedu.springcloud.example.springclouduserservice;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * 设置自己ping服务器是否可用的策略 BaseLoadBalancer.etupPingTask默认每10秒执行一次
 * 心跳
 **/
public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("isAlive" + server.getHost() + ":" + server.getPort());
        return true;
    }
}
