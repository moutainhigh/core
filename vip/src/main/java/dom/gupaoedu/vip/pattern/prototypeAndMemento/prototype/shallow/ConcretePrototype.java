package dom.gupaoedu.vip.pattern.prototypeAndMemento.prototype.shallow;


import lombok.Data;

import java.util.List;

/**
 * ǳ��¡  �����з��� age��name�ǻ����������ͣ���hobbies�������������ͣ��������͸��Ƶ�������ָ�򣬲��Ǿ����ֵ
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;
    private String name;
    // �����¡�Ĳ��Ǿ����ֵ�����ڴ��е����ã��������ڴ��еľ����ֵ  �����з���
    private List<String> hobbies;

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype)super.clone();
        } catch (CloneNotSupportedException e) {
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
