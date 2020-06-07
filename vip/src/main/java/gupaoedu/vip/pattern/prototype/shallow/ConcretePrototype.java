package gupaoedu.vip.pattern.prototype.shallow;


import lombok.Data;

import java.util.List;

/**
 * 浅克隆  代码有风险 age和name是基本数据类型，而hobbies属性是引用类型，引用类型复制的是引用指向，不是具体的值
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;
    private String name;
    // 这里克隆的不是具体的值而是内存中的引用，而不是内存中的具体的值  这里有风险
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
