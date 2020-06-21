package com.gupaoedu.example.rcp;

import com.gupaoedu.example.RpcRequest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 远程连接  去连接订单服务
 * http://www.gupaoedu.com
 **/
public class RpcNetTransport {

    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    // 客户端使用Socket去 连接服务端
    public Socket newSocket() throws IOException {
        Socket socket = new Socket(host, port);
        return socket;
    }

    /**
     * 向服务器发送请求
     * @param request  请求对象
     * @return 返回服务端的响应
     */
    public Object send(RpcRequest request) {
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            Socket socket = newSocket();
            //IO操作  序列化
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush(); // 写出去

            // 反序列化 读取服务端给的相应
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
