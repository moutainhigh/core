package com.gupaoedu.vip.distributed.socket.nio.selectdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NioServer
 **/
public class NewIoServer {

    static Selector selector;

    // Nio里面三个很重要的地方
    // Channel管道   Buffer缓冲区    Selector多路复用器---->基于底层poll事件机制，一个线程去监听所有的渠道Channel，所以处理的连接数很多
    // selector 必须是非阻塞的，selector多路复用器是为了提升服务端同时并行处理的连接数量，相比用多线程的方式，这里只需要一个线程就可以管理多个通道，
    // 所以这就是多路复用
    // 零拷贝
    public static void main(String[] args) {
        try {
            selector = Selector.open();// 打开多路复用
            //selector 必须是非阻塞
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false); //设置为非阻塞
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); //把连接事件注册到多路复用器上
            while (true) {
                selector.select(); //阻塞机制 对于服务器而言这里是获取连接，轮训一次，这里获取一个连接
                Set<SelectionKey> selectionKeySet = selector.selectedKeys(); //可能会有很多个通道就绪，所以这里是一个list
                Iterator<SelectionKey> iterable = selectionKeySet.iterator();
                while (iterable.hasNext()) {
                    SelectionKey key = iterable.next();
                    iterable.remove(); // 响应完之后要移除掉
                    if (key.isAcceptable()) { //连接事件
                        handleAccept(key);
                    } else if (key.isReadable()) { //读的就绪事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 收到连接事件进行处理
    private static void handleAccept(SelectionKey selectionKey) {
        //
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();//一定会有一个连接
            socketChannel.configureBlocking(false); // 设置非阻塞
            socketChannel.write(ByteBuffer.wrap("Hello Client,I'm NIO Server".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ); //注册读事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取数据
    private static void handleRead(SelectionKey selectionKey) {
        // 这里读到的数据一定能都拿到这个通道，因为在连接进来的时候注册了读事件
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            socketChannel.read(byteBuffer); //这里是一定有值
            System.out.println("server receive msg:" + new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
