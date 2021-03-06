package dom.gupaoedu.vip.pattern.visitor.general;

// 具体访问者  实现对具体元素的操作
public class ConcreteVisitorA implements IVisitor {

    public void visit(ConcreteElementA element) {
        String result = element.operationA();
        System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
    }

    public void visit(ConcreteElementB element) {
        int result = element.operationB();
        System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
    }
}