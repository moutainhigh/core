package dom.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // ????????
        JdkMeipo jdkMeipo = new JdkMeipo();
        // ????? zhangsan ????($Proxy0) ?? Zhangsan ??????κι??
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

        /**
         * ????????????????
         * ?????????????  $Proxy0.class???????????????
         */
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        try {
            FileOutputStream os = new FileOutputStream("F://$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();
//        zhaoliu.buyInsure();



    }
}
