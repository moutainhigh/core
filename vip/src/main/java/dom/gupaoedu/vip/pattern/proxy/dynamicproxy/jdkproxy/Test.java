package dom.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy;


/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // ʹ�ô�����
        JdkMeipo jdkMeipo = new JdkMeipo();
        // ����� zhangsan ����($Proxy0) �� Zhangsan ��û���κι�ϵ
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();

        /**
         * ���������̬����ģʽ
         * �鿴�������Ĵ���  $Proxy0.classΪ�������ɵĴ�����
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
