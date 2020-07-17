package com.gupaoedu.vip.distributed.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/17 12:24
 * @Version:1.0
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("开始监听");
        while (true) {
            Socket socket = serverSocket.accept(); //监听客户端连接(连接阻塞）
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//输入流
            String s = bufferedReader.readLine(); //被阻塞了
            String clientStr = s; //读取客户端的一行数据
            System.out.println("接收到客户端的信息：" + clientStr);

            //写回去
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我收到了信息\n");
            bufferedWriter.flush();
        }
    }
}
