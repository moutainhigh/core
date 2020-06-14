package gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 抽象组件 :可以是一个接口或者抽象类,其充当被装饰类的原始对象,规定了被装饰对象的行为;
 * 需要具体组件去实现或继承
 */
public abstract class Battercake {

    // 被装饰对象的原始行为
    protected abstract String getMsg();

    // 被装饰对象的原始行为
    protected abstract int getPrice();

}
