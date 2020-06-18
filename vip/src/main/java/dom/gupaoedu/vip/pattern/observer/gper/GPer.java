package dom.gupaoedu.vip.pattern.observer.gper;

import java.util.Observable;

/**
 * 具体主题者 具体被观察者，当内部状态变化时，会通知已注册的所有观察者；
 * 继承JDK内置的抽象主题者，
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";

    // 单例模式
    private static final GPer gper = new GPer();

    private GPer() {
    }

    public static GPer getInstance() {
        return gper;
    }

    public String getName() {
        return name;
    }

    // 通知观察者
    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
