package com.gupaoedu.spring.example.vip.distributed.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ClientSocketDemo {

    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",8080);
            User user=new User();
            user.setName("mic");
            //如何传递？
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //TODO
        }


    }
}
