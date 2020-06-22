package com.gupaoedu.spring.example.vip.distributed.serialize;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class SerializerMain {

    public static void main(String[] args) {
//        ISerializer serializer=new JavaSerializer();
       /* User user=new User();
        user.setName("Mic");
        user.setAge(18);

        byte[] bytes=serializer.serialize(user);
        System.out.println(bytes.length); //
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]+ " ");
        }
        System.out.println();
        User userRever=serializer.deserialize(bytes);
        System.out.println(userRever);*/
        User user=new User();
        user.setName("Mic");
        user.setAge(18);
        ISerializer serializer=new HessianSerializer();
        byte[] bytes=serializer.serialize(user);
        System.out.println(bytes.length);
        System.out.println(new String(bytes));
        User userRever=serializer.deserialize(bytes);
        System.out.println(userRever);
    }
}
