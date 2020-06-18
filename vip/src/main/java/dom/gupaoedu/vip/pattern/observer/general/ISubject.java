package dom.gupaoedu.vip.pattern.observer.general;

/**
 * 抽象主题者 该角色是一个抽象类或接口，定义增加、删除、通知观察者对象的方法；
 */
public interface ISubject<E> {
    /** 观察者注册 */
    boolean attach(IObserver<E> observer);
    /** 观察者删除 */
    boolean detach(IObserver<E> observer);
    /** 通知所有观察者 */
    void notify(E event);
}