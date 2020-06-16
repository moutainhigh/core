package com.gupaoedu.vip.distributed.serialize.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * 用protobuf序列化与反序列化
 * 咕泡学院，只为更好的你
 * http://www.gupaoedu.com
 **/
public class ProtobufMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        // 用protobuf创建对象的方式
        UserProto.User user = UserProto.User.newBuilder().setName("Mic").setAge(599).build();
        ByteString bytes = user.toByteString();
        System.out.println(bytes.size()); // 序列化长度为7

        //-300 ->zigzag(可逆的算法) 599  -> varint  (-41 4)

        for (byte bt : bytes.toByteArray()) {
            System.out.print(bt + " ");
            //  Mic / 18
            //
            //10 3 77 105 99 16 18
            //10 3 77 105 99 16 -84 2

            //10 3 77 105 99 16 -84 2 24 -41 4
        }
        System.out.println();
        // 反序列化
        UserProto.User userRever = UserProto.User.parseFrom(bytes);
        System.out.println(userRever);
    }
}
