package com.gupaoedu.example;

import com.gupaoedu.example.merdiator.Mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 请求处理器  异步处理客户端的请求
 **/
public class ProcessorHandler implements Runnable {

    // 监听的客户端的连接
    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            //反序列化
            inputStream = new ObjectInputStream(socket.getInputStream());//?
            RpcRequest request = (RpcRequest) inputStream.readObject();

            //路由
            Mediator mediator = Mediator.getInstance();
            Object rs = mediator.processor(request);
            System.out.println("调用服务端代码的执行结果：" + rs);

            // 序列化
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rs);
            outputStream.flush(); // 数据写出去
            System.out.println("代码执行结束，服务端回应客户端完成。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO 关闭流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
