package dom.gupaoedu.vip.pattern.observer.general;

//抽象观察者 定义响应通知的方法；
public interface IObserver<E> {
    void update(E event);
}