package com.gupaoedu.example;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 初始化服务端连接，用来接收客户端的请求
 * ApplicationListener作用：当容器初始化完成之后，需要处理一些操作
 * 首先，需要实现ApplicationListener接口并实现onApplicationEvent方法。把需要处理的操作放在onApplicationEvent中进行处理：
 **/
//spring 容器启动完成之后，会发布一个ContextRefreshedEvent=
@Component
public class SocketServerInitial implements ApplicationListener<ContextRefreshedEvent> {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 容器启动之后调用方法
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println( "容器初始化：" + this.getClass().getName() + ".onApplicationEvent init");
        //启动服务
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept(); //监听客户端请求  阻塞
                executorService.execute(new ProcessorHandler(socket));  // Socket是阻塞的，这里用线程池解决异步问题
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
