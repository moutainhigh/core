package aom.gupaoedu.vip.design.liskovsutiution.methodreturn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom on 2020/2/16.
 */
public class Child extends Base {
    @Override
    public HashMap method() {
        HashMap hashMap = new HashMap();
        System.out.println("执行子类的method");
        hashMap.put("msg","子类method");
        return hashMap;
    }
}
