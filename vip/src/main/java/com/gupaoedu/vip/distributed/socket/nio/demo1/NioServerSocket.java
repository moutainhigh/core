package com.gupaoedu.vip.distributed.socket.nio.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Titile: IntelliJ IDEA
 * @Description:
 * @Author: mafenglei @Date: 2020/7/17 20:50
 * @Version:1.0
 */
public class NioServerSocket {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false); //设置为非阻塞  因为NIO默认阻塞的
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            // 这里轮训肯定消耗性能，所以用多路复用机制 Selector， 见selectdemo
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept(); // 监听一个客户端请求
                if (socketChannel != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);// 把数据读取到缓冲区
                    System.out.println(new String(byteBuffer.array()));// 读取
                    //  写出数据
                    // 反转，因为同一个管道，读的数据要和写出去的数据相反，所以要反转​，把数据读取
                    // 到的时候是往前叠加的，所以写出去的时候要从头开始所以要flip
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);// 写出去
                } else {
                    Thread.sleep(1000);
                    System.out.println("连接未就绪");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
