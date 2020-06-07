package gupaoedu.vip.pattern.prototype.deep;


import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 深克隆：通过序列化和烦序列化深克隆，再通过反射，必须实现序列化
 * 性能不好，占用IO
 */
@Data
public class ConcretePrototype implements Cloneable, Serializable {

    private int age;
    private String name;
    private List<String> hobbies;

    // 必须重写clone方法，具有clone的功能
    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 此方法加深理解方法，调用此方法也可以，但是硬编码，不推荐使用此方法
    public ConcretePrototype deepCloneHobbies() {
        try {
            ConcretePrototype result = (ConcretePrototype) super.clone();
            // ArrayLists模式实现了深克隆，但这硬编码还不如通过序列化反序列化好，
            result.hobbies = (List) ((ArrayList) result.hobbies).clone();
            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 深克隆：通过序列化和烦序列化深克隆，再通过反射
    public ConcretePrototype deepClone() {
        try {
            // 输出流  序列化
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 输入流   反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            // 通过反射创建对象
            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
