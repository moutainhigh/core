package dom.gupaoedu.vip.pattern.prototype.deep;


import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ���¡��ͨ�����л��ͷ����л����¡����ͨ�����䣬����ʵ�����л�
 * ���ܲ��ã�ռ��IO
 */
@Data
public class ConcretePrototype implements Cloneable, Serializable {

    private int age;
    private String name;
    private List<String> hobbies;

    // ������дclone����������clone�Ĺ���
    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // �˷���������ⷽ�������ô˷���Ҳ���ԣ�����Ӳ���룬���Ƽ�ʹ�ô˷���
    public ConcretePrototype deepCloneHobbies() {
        try {
            ConcretePrototype result = (ConcretePrototype) super.clone();
            // ArrayListsģʽʵ�������¡������Ӳ���뻹����ͨ�����л������л��ã�
            result.hobbies = (List) ((ArrayList) result.hobbies).clone();
            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

    }

    // ���¡��ͨ�����л��ͷ����л����¡����ͨ������
    public ConcretePrototype deepClone() {
        try {
            // �����  ���л�
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // ������   �����л�
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            // ͨ�����䴴������
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
