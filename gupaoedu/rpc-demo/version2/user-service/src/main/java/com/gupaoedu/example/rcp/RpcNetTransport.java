package com.gupaoedu.example.rcp;

import com.gupaoedu.example.RpcRequest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * RPC用于远程调用给订单服务通讯
 **/
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() throws IOException {
        // 客户端使用Socket给服务端通信
        Socket socket = new Socket(host, port);
        return socket;
    }

    /**
     * 发送请求给服务端
     * @param request
     * @return
     */
    public Object send(RpcRequest request) {
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            Socket socket = newSocket();
            //IO操作 序列化
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();

            // 反序列化读取服务端的回复
            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //TODO 不写了
        }
        return null;
    }
}
