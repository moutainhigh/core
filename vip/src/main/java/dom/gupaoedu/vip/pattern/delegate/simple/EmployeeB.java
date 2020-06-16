package dom.gupaoedu.vip.pattern.delegate.simple;

/**
 * 具体任务角色
 */
public class EmployeeB implements IEmployee {
    protected String goodAt = "平面设计";
    public void doing(String task) {
        System.out.println("我是员工B，我擅长" + goodAt + ",现在开始做" +task + "工作");
    }
}
