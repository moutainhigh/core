package dom.gupaoedu.vip.pattern.delegate.general;

/**
 * 具体任务角色
 */
public class ConcreteA implements Task {
    public void doTask() {
        System.out.println("执行 , 由A实现");
    }
}