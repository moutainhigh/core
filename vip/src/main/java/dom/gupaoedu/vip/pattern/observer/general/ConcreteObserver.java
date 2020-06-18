package dom.gupaoedu.vip.pattern.observer.general;

/**
 * 具体观察者 在得到状态更新时，会自动做出响应。
 */
public class ConcreteObserver<E> implements IObserver<E> {
    /** 观察者收到通知后调用的方法 */
    public void update(E event) {
        System.out.println("观察者 收到  通知: " + event);
    }
}