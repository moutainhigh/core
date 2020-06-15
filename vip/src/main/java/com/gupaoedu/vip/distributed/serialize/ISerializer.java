package com.gupaoedu.vip.distributed.serialize;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public interface ISerializer {

    // 序列化
    <T> byte[] serialize(T obj);

    // 反序列化
    <T> T deserialize(byte[] data);
}
