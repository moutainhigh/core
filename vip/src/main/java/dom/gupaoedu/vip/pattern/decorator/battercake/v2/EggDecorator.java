package dom.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 扩展功能的具体装饰器： 抽象装饰器的具体实现类，理论上,每个具体装饰器都扩展了具体组件对象的一种功能:
 */
public class EggDecorator extends BattercakeDecorator {

    // 把被修饰的对象传入到抽象装饰中
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    // 这里是重写扩展原先对象的
    protected String getMsg() {
        // 调用被修饰对象的方法
        return super.getMsg() + "1个鸡蛋";
    }

    public int getPrice() {
        // 调用被修饰对象的方法
        return super.getPrice() + 1;
    }

}
