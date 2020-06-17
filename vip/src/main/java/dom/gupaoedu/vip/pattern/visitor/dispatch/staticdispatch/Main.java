package dom.gupaoedu.vip.pattern.visitor.dispatch.staticdispatch;

/**
 * 静态分派
 */
public class Main {
    public void test(String string){
        System.out.println("string" + string);
    }
    public void test(Integer integer){
        System.out.println("integer" + integer);
    }

    public static void main(String[] args) {
        String string = "1";
        Integer integer = 1;
        Main main = new Main();
        // 在代码编译期间就知道了方法的执行
        main.test(integer);
        main.test(string);
    }
}
