package gupaoedu.vip.pattern.prototype.singleton;


import lombok.Data;

import java.util.List;

/**
 * 在克隆环境下，单例遭到破坏，所以在克隆下就不能使用单例
 * 所以原型跟单例是冲突的，要么是原型就不能单例，要么是单例就不能原型，不能同时是单例又是原型
 */
@Data
public class ConcretePrototype implements Cloneable {

    private int age;
    private String name;
    private List<String> hobbies;

    private static  ConcretePrototype instance = new ConcretePrototype();

    private ConcretePrototype(){}

    public static ConcretePrototype getInstance(){
        return instance;
    }

    @Override
    public ConcretePrototype clone() {
       return instance;
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
