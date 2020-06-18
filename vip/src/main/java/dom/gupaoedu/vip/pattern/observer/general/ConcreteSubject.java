package dom.gupaoedu.vip.pattern.observer.general;

import java.util.ArrayList;
import java.util.List;

//具体主题者 具体被观察者，当内部状态变化时，会通知已注册的所有观察者；
public class ConcreteSubject<E> implements ISubject<E> {
    private List<IObserver<E>> observers = new ArrayList<IObserver<E>>();

    // 观察者注册
    public boolean attach(IObserver<E> observer) {
        // 只要不包含就注册
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    // 删除观察者
    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    // 通知所有观察者
    public void notify(E event) {
        for (IObserver<E> observer : this.observers) {
            observer.update(event);
        }
    }
}