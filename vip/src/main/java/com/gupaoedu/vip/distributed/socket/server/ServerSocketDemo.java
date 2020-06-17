package com.gupaoedu.vip.distributed.socket.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ServerSocketDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //localhost: 8080
            serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept(); //监听客户端连接(连接阻塞）
                System.out.println(socket.getPort());
                executorService.execute(new SocketThread(socket)); //异步  Socket是阻塞的，这里用线程池解决阻塞问题
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //TODO
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
