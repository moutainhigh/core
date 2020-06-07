package gupaoedu.vip.pattern.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {


    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //拷贝原型对象
        ConcretePrototype cloneType = prototype.clone();
        cloneType.getHobbies().add("技术控");

        /**
         * 这个时候会发现有问题，我们是对拷贝的对象增加了技术控，打印结果发现原先的对象也增加了此字段。
         * 所以这个时候浅克隆对象有问题，就需要深克隆
         */
        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());

    }

}
