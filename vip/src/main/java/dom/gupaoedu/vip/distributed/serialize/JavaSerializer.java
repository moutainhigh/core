package dom.gupaoedu.vip.distributed.serialize;

import java.io.*;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class JavaSerializer implements ISerializer{

    //序列化
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

        try {
            ObjectOutputStream outputStream=new ObjectOutputStream(byteArrayOutputStream);
//            ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("user"));
            outputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    //反序列化
    @Override
    public <T> T deserialize(byte[] data) {
        ByteArrayInputStream byteArrayOutputStream=new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayOutputStream);
//            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("user")));
            return (T)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
