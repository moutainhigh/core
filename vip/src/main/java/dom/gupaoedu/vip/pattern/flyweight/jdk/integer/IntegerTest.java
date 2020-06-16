package dom.gupaoedu.vip.pattern.flyweight.jdk.integer;

/**
 * Created by Tom.
 */
public class IntegerTest {
    public static void main(String[] args) {

        // Integer利用了享元模式，Integer 大于-128 小于127就会从缓存池里面直接取，不是这个区间的就会重新new对象
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println("a==b:" + (a==b)); // a跟b在区间范围内，直接从缓存池里面取值，
        System.out.println("c==d:" + (c==d));




        Integer e = Integer.valueOf(127);
        Integer f = 127;

        Integer g = Integer.valueOf(128);
        Integer h = 128;

        System.out.println(e==f);  //true a跟b在区间范围内，直接从缓存池里面取值，
        System.out.println(g==h);  // 不在区间范围内，所以会new 所以false
    }
}
