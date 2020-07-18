package com.gupaoedu.vip.distributed.socket.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Titile: IntelliJ IDEA
 * @Description:
 * @Author: mafenglei @Date: 2020/7/17 20:50
 * @Version:1.0
 */
public class NioClientSocket {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
//        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        // 在这段代码中，并不意味这连接已经建立好了
        if(socketChannel.isConnectionPending()){
            socketChannel.finishConnect();
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("Hello , I'm SocketClientChannel Client".getBytes());// 把数据写到缓存区
        byteBuffer.flip();// 反转
        socketChannel.write(byteBuffer); // 写出去
        // 读取数据
        byteBuffer.clear();
        int i = socketChannel.read(byteBuffer); // 阻塞 因为这里如果不阻塞，发完就结束，服务端在没还没有读的时候，客户端关闭，服务端会报错说连接已经关闭
        if (i > 0) {
            System.out.println("收到了服务端的数据" + new String(byteBuffer.array()));
        } else {
            System.out.println("没有收到数据");
        }
    }
}
