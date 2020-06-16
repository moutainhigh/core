package dom.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 抽象装饰器:
 * 装饰被装饰对象(具体组件)的装饰器,内部一定要有一个属性指向抽象组件;其实现一般是一个抽象类,
 * 主要是为了让其子类按照其构造形式传入一个抽象组件,这是强制的通用行为(当然,如果系统中装饰逻辑单一,
 * 并不需要实现许多装饰器,那么我们可以直接省略该类,而直接实现一个具体装饰器( SauageDecorator )即可) ;
 */
public abstract class BattercakeDecorator extends Battercake {

    /**
     * 指向被修饰的抽象组件对象
     */
    private Battercake battercake;

    /**
     * 构造方法，传入被修饰的组件对象
     *
     * @param battercake 实现了扩展功能的具体装饰器
     */
    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected String getMsg() {
        //转发请求给修饰的组件对象
        return this.battercake.getMsg();
    }

    public int getPrice() {
        return this.battercake.getPrice();
    }
}
