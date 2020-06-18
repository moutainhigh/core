package dom.gupaoedu.vip.pattern.visitor.kpi;

import java.util.Random;

/**
 * 具体元素  提供接受访问者的具体实现。
 */
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //考核的是每年新产品研发数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
