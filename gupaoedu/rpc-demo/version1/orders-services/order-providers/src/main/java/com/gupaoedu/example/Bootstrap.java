package com.gupaoedu.example;

/**
 * 启动入口
 * http://www.gupaoedu.com
 **/
public class Bootstrap {

    public static void main(String[] args) {
        //SPRING BOOT 监听要调用的接口
        IOrderService orderService = new OrderServiceImpl();

        // 让代理去处理
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(orderService, 8080);
    }
}
