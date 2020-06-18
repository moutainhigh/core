package dom.gupaoedu.vip.pattern.visitor.kpi;

import java.util.LinkedList;
import java.util.List;

/**
 * 结构对象   该类内部维护了元素集合，并且提供方法接受访问者对该集合所有元素进行操作
 */
public class BusinessReport {
    private List<Employee> employees = new LinkedList<Employee>();

    public BusinessReport() {
        employees.add(new Manager("产品经理A"));
        employees.add(new Engineer("程序员A"));
        employees.add(new Engineer("程序员B"));
        employees.add(new Engineer("程序员C"));
        employees.add(new Manager("产品经理B"));
        employees.add(new Engineer("程序员D"));
    }

    // 接受访问
    public void showReport(IVisitor visitor){
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
