package com.gupaoedu.example.rcp;

import com.gupaoedu.example.IOrderService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 代理
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        // 动态调用的目标为 IOrderService
        IOrderService orderService = rpcProxyClient.clientProxy(IOrderService.class, "localhost", 8080);

        System.out.println("============服务器响应结果：============");
        System.out.println(orderService.queryOrderList());
        System.out.println(orderService.orderById("Mic"));

    }
}
