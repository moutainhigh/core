package aom.gupaoedu.vip.design.methodparam;

import java.util.HashMap;

/**
 * Created by Tom on 2020/2/16.
 */
public class MethodParamTest {
    public static void main(String[] args) {
        Base child = new Child();
//        Child child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
