package gupaoedu.vip.pattern.delegate.general;

/**
 * 具体任务角色
 */
public class ConcreteB implements Task {
    public void doTask() {
        System.out.println("执行 , 由B实现");
    }
}