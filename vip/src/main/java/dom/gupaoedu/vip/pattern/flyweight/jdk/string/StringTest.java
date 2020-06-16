package dom.gupaoedu.vip.pattern.flyweight.jdk.string;

/**
 * Created by Tom.
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";  // 常量在代码编译时就放在了常量池
        String s2 = "hello";
        String s3 = "he" + "llo"; // jdk对编译做了处理，会把常量加上常量还是常量，会直接编译成hello常量,最终还是会指向hello的常量，所以s1个s3是相等的，能在编译期间处理，就不会放在运行时处理
        String s4 = "hel" + new String("lo"); // 到这里为止，常量池已经有三个值，hello  和hel 和 lo 然后又在内存堆里面有new了一个值
        String s5 = new String("hello"); //重新创建对象
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8; // 代码在编译期间只要看到变量就不会做优化，如果是常量就会优化，机器还是很傻的额，只能看到现有的东西，不能去预测，所以s9跟s1是不相等的为false

        System.out.println(s1==s2);//true   s1和s2对应常量池中同一个地址，所以为true
        System.out.println(s1==s3);//true
        System.out.println(s1==s4);//false    s1、s2、s3都是常量，只要是常量都会在编译期间完成，而s4是 把String值取出来，再把lo得值取出来，再加上hel的值，然后就分配了s4的内存地址，这个地址就跟s1的内存地址肯定不相等
        System.out.println(s1==s5);//false
        System.out.println(s1==s6);//true
        System.out.println(s1==s9);//false
        System.out.println(s4==s5);//false
        System.out.println(s1==s6);//true

        // 结论：jdk对spring的优化，只是增加了常量池，是利用享元模式进行的优化，把自己所能看到的内容会先放到常量池里面，以后再运行期间就可以直接拿过来直接使用
    }
}
