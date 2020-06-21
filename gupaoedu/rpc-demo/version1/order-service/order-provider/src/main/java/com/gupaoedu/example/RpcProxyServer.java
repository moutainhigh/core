package com.gupaoedu.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 订单服务代理
 * <p>
 * http://www.gupaoedu.com
 **/
public class RpcProxyServer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 订单服务监听
     *
     * @param service 监听的类（就会调用服务端接口实现者的代码）
     * @param port    监听端口号
     */

    public void publisher(Object service, int port) {
        System.out.println("Service start...");
        // 服务端是ServerSocket  客户端是Socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            // 持续不断的监听
            while (true) {
                Socket socket = serverSocket.accept(); //监听客户端请求  阻塞
                // 接受的请求异步去处理  因为Socket是阻塞的要异步处理只能用线程池   每一个请求开启一个线程去处理
                // * http://www.gupaoedu.com
                executorService.execute(new ProcessorHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
