package gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 装饰器模式
 */
public class BattercakeDecorator extends Battercake {


    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected String getMsg() {
        return this.battercake.getMsg();
    }

    public int getPrice() {
        return this.battercake.getPrice();
    }

}
