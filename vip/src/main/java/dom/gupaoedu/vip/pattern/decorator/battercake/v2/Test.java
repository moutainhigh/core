package dom.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 装饰器代码使用
 */
public class Test {
    public static void main(String[] args) {

        Battercake b1 = new BaseBattercake(); // 首先创建需要被装饰的原始对象(即要被装饰的对象) 基本功能
        BattercakeDecorator battercakeA = new EggDecorator(b1);//给对象透明的增加功能A并调用
        System.out.println(battercakeA.getMsg() + ",总价" + battercakeA.getPrice());

        BattercakeDecorator battercakeB = new EggDecorator(battercakeA); //给对象透明的增加功能B并调用
        System.out.println(battercakeB.getMsg() + ",总价" + battercakeB.getPrice());

        BattercakeDecorator battercakeC = new SauageDecorator(battercakeB);//给对象透明的增加功能C并调用
        System.out.println(battercakeC.getMsg() + ",总价" + battercakeC.getPrice());

        BattercakeDecorator en = new SauageDecorator(battercakeA);//装饰器也可以装饰具体的装饰对象，此时相当于给对象在增加A的功能基础上在添加功能B
        System.out.println(en.getMsg() + ",总价" + en.getPrice());

    }
}
