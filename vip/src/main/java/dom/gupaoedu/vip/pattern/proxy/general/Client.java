package dom.gupaoedu.vip.pattern.proxy.general;

/**
 * �ͻ��˵��ô���
 */
public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
