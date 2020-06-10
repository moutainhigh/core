package gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {


        Battercake battercake;

        battercake = new BaseBattercake(); // 基本功能

        battercake = new EggDecorator(battercake);// 在不改变父类基本功能的基础上扩展功能

        battercake = new EggDecorator(battercake);// 在不改变父类基本功能的基础上扩展功能

        battercake = new SauageDecorator(battercake);// 在不改变父类基本功能的基础上扩展功能

        System.out.println(battercake.getMsg() + ",总价" + battercake.getPrice());

    }
}
