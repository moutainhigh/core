package dom.gupaoedu.vip.pattern.template.general;

/**
 * 代码使用
 */
public class Test {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMehthod();
        abc = new ConcreteClassB();
        abc.templateMehthod();
    }
}
