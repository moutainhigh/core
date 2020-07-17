package com.gupaoedu.vip.distributed.socket.io.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 线程处理
 **/
public class SocketThread implements Runnable {
    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//输入流
            String s = bufferedReader.readLine(); //被阻塞了
            String clientStr = s; //读取客户端的一行数据
            System.out.println("接收到客户端的信息：" + clientStr);
            //写回去
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我收到了信息\n");
            bufferedWriter.flush();

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {

        }
    }
}
