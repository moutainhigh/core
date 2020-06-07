package gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy;


import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // 使用代理类
        JdkMeipo jdkMeipo = new JdkMeipo();
        // 这里的 zhangsan 而是($Proxy0) 跟 Zhangsan 类没有任何关系
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

        /**
         * 深入分析动态代理模式
         * 查看代理具体的代码  $Proxy0.class为具体生成的代理类
         */
//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
//        try {
//            FileOutputStream os = new FileOutputStream("F://$Proxy0.class");
//            os.write(bytes);
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println();

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();
//        zhaoliu.buyInsure();



    }
}
