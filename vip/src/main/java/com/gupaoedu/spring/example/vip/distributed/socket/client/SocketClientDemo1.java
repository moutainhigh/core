package com.gupaoedu.spring.example.vip.distributed.socket.client;

import java.io.*;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class SocketClientDemo1 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 8080);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端1，发送了一个消息\n");
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//输入流
            String serverLine = bufferedReader.readLine(); //读取服务端返回的数据
            System.out.println("服务端返回的数据:" + serverLine);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
