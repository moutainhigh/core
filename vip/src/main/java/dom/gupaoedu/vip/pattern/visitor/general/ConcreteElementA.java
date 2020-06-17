package dom.gupaoedu.vip.pattern.visitor.general;

// 具体元素  提供接受访问者的具体实现。
public class ConcreteElementA implements IElement {

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return this.getClass().getSimpleName();
    }

}