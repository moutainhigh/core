package com.gupaoedu.spring.example.vip.distributed.serialize;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class HessianSerializer implements ISerializer{
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        HessianOutput hessianOutput=new HessianOutput(byteArrayOutputStream);
        try {
            hessianOutput.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data) {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(data);
        HessianInput hessianInput=new HessianInput(byteArrayInputStream);
        try {
            return (T)hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
