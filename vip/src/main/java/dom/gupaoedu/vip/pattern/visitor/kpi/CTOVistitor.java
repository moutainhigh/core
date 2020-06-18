package dom.gupaoedu.vip.pattern.visitor.kpi;

/**
 * 具体访问者  实现对具体元素的操作
 */
public class CTOVistitor implements IVisitor {
    public void visit(Engineer engineer) {
        System.out.println("工程师" + engineer.name + "，代码行数：" + engineer.getCodeLines());
    }

    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + "，产品数量：" + manager.getProducts());
    }
}
