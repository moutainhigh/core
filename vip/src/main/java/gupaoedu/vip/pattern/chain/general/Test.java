package gupaoedu.vip.pattern.chain.general;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        // 建立链表的关系
        handlerA.setNextHanlder(handlerB);
        handlerA.handleRequest("requestB");
    }
}
