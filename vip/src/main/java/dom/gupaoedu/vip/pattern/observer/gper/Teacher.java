package dom.gupaoedu.vip.pattern.observer.gper;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体观察者 在得到状态更新时，会自动做出响应。
 * 要实现jdk内置的观者者Observer 只有一个update做出响应方法
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    /**
     * 观察者收到通知后调用的方法
     */
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        System.out.println("======================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自" + gper.getName() + "的提问，希望您解答。问题内容如下：\n" +
                question.getContent() + "\n" + "提问者：" + question.getUserName());
    }
}
