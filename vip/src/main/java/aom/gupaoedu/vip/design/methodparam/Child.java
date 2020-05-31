package aom.gupaoedu.vip.design.methodparam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom on 2020/2/16.
 */
public class Child extends Base {

    // 如果注释此方法，则调用父类的方法
    @Override
    public void method(HashMap map) {
        System.out.println("执行子类HashMap入参方法");
    }

    // 如果注释上面的方法，则调用子类参数为Map的方法
    //当子类的方法重载父类的方法时，方法的前置条件（即方法的输入/入参）要比父类方法的输入参数更宽松。
    public void method(Map map) {
        System.out.println("执行子类Map入参方法");
    }
}
