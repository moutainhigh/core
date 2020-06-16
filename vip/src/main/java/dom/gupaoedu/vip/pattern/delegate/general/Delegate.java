package dom.gupaoedu.vip.pattern.delegate.general;

import java.util.Random;

/**
 * 委派角色
 */
public class Delegate implements Task {
    public void doTask() {
        System.out.println("代理执行开始....");

        Task task = null;
        // 相等于钩子
        if (new Random().nextBoolean()) {
            task = new ConcreteA();
            task.doTask();
        } else {
            task = new ConcreteB();
            task.doTask();
        }

        System.out.println("代理执行完毕....");
    }
}