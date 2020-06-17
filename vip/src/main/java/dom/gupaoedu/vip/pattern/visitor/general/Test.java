package dom.gupaoedu.vip.pattern.visitor.general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();
        System.out.println("ConcreteVisitorA handle elements:");
        IVisitor visitorA = new ConcreteVisitorA(); //  访问者
        collection.accept(visitorA); // 接受访问

        System.out.println("------------------------------------");
        System.out.println("ConcreteVisitorB handle elements:");
        IVisitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);
    }

}
