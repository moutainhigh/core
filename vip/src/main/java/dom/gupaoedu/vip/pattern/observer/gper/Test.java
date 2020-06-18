package dom.gupaoedu.vip.pattern.observer.gper;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // 被观察者
        GPer gper = GPer.getInstance();

        // 观察者
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("Jerry");
        // 观察者去注册
        gper.addObserver(tom);
        gper.addObserver(jerry);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        // 发布通知,上面的观者者就能收到通知
        gper.publishQuestion(question);
    }
}
