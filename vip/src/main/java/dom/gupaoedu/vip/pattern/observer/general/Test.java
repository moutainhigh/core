package dom.gupaoedu.vip.pattern.observer.general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        // 被观察者
        ISubject<String> observable = new ConcreteSubject<String>();
        // 观察者
        IObserver<String> observer = new ConcreteObserver<String>();

        // 观察者去进行注册
        observable.attach(observer);

        // 发布通知,上面的观者者就能收到通知
        observable.notify("hello");
    }

}
