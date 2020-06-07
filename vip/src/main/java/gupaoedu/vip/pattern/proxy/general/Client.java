package gupaoedu.vip.pattern.proxy.general;

/**
 * 客户端调用代码
 */
public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
