package dom.gupaoedu.vip.pattern.visitor.dispatch.dymdispatch;

/**
 * 动态分派
 */
public class Main {
    public static void main(String[] args) {
        // 再运行时确定执行的方法
        Person man = new Man();
        Person woman = new WoMan();

        man.test();
        woman.test();
    }
}
