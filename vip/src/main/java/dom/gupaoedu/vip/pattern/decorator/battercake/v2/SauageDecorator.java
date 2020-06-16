package dom.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 扩展功能的具体装饰器： 抽象装饰器的具体实现类，理论上,每个具体装饰器都扩展了具体组件对象的一种功能:
 */
public class SauageDecorator extends BattercakeDecorator {

    public SauageDecorator(Battercake battercake) {
        super(battercake);
    }

    protected String getMsg() {
        return super.getMsg() + "1根香肠";
    }

    public int getPrice() {
        return super.getPrice() + 2;
    }

}
