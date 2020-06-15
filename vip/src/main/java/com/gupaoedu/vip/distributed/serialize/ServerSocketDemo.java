package com.gupaoedu.vip.distributed.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ServerSocketDemo {

    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(8080);
            Socket socket=serverSocket.accept();
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            //? 如何转化成一个User对象？
            User user=(User)objectInputStream.readObject();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //TODO
        }


    }
}
