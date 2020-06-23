package com.gupaoedu.vip.distributed.serialize;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class XMLSerializer implements ISerializer{
    XStream stream=new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        return stream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data) {
        return (T)stream.fromXML(new String(data));
    }
}
