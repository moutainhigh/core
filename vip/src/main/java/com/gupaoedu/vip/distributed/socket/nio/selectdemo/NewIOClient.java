package com.gupaoedu.vip.distributed.socket.nio.selectdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NioClient
 **/
public class NewIOClient {

    static Selector selector;

    public static void main(String[] args) {
        try {
            selector = Selector.open(); //  打开多路复用器
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            socketChannel.register(selector, SelectionKey.OP_CONNECT); //连接事件
            while (true) {
                selector.select(); //这里对于服务端不一样，这里只有一个客户端连接，这里连接只会建立一次，这样做只是为了更好的看到现象
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isConnectable()) { //连接事件
                        handleConnect(key);
                    } else if (key.isReadable()) { // 可读事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 收到连接事件进行处理
    private static void handleConnect(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (socketChannel.isConnectionPending()) {
            // 完成连接
            socketChannel.finishConnect();
        }
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("Hello Server,I'm NIo Client".getBytes()));
        socketChannel.register(selector, SelectionKey.OP_READ); // 注册读事件到多路复用器
    }

    // 读取数据
    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //TODO  这里读一次，如果怕缓冲区买的话，这里可以使用过while循环
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 这里读到的数据一定能都拿到这个通道，因为在连接进来的时候注册了读事件
        socketChannel.read(byteBuffer);
        System.out.println("client receive msg:" + new String(byteBuffer.array()));

    }

}
