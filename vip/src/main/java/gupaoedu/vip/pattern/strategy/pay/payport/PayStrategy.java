package gupaoedu.vip.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文（桥接） 屏蔽高层模块（客户端）对策略，算法的直接访问，封装可能存在的变化
 */
public class PayStrategy {
    public static  final String ALI_PAY = "AliPay";
    public static  final String JD_PAY = "JdPay";
    public static  final String WECHAT_PAY = "WechatPay";
    public static  final String UNION_PAY = "UnionPay";
    public static  final String DEFAULT_PAY = ALI_PAY;

    // 容器 存放策略
    private static Map<String,Payment> strategy = new HashMap<String,Payment>();

    // 初始化
    static {
        strategy.put(ALI_PAY,new AliPay());
        strategy.put(JD_PAY,new JDPay());
        strategy.put(WECHAT_PAY,new WechatPay());
        strategy.put(UNION_PAY,new UnionPay());
    }

    // 根据用户选择返回不同的策略  这里使用了工厂模式
    public static Payment get(String payKey){
        if(!strategy.containsKey(payKey)){
            return strategy.get(DEFAULT_PAY); // 默认的策略
        }
        return strategy.get(payKey);
    }
}
