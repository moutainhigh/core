package dom.gupaoedu.vip.pattern.visitor.kpi;

import java.util.Random;

/**
 * 抽象元素   接口或抽象类，定义了一个接受访问者访问方法，表示所有元素类型都支持被访问者访问；
 */
public abstract class Employee {
    public String name;
    public int kpi;  //员工KPI

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    //接收访问者的访问
    public abstract void accept(IVisitor visitor);
}
