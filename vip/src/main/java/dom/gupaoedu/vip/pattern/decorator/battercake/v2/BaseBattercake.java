package dom.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 实现 或者 继承抽象组件的一个 具体组件 : 也即被装饰对象（原始对象基本功能）;
 */
public class BaseBattercake extends Battercake {

    protected String getMsg() {
        return "煎饼";
    }

    public int getPrice() {
        return 5;
    }

}
