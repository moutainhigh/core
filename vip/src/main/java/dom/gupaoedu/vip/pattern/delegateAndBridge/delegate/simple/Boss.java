package dom.gupaoedu.vip.pattern.delegateAndBridge.delegate.simple;

/**
 * 分配任务
 */
public class Boss {
    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
