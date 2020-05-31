package gupaoedu.vip.pattern.strategy.pay.payport;

/**
 * 具体的策略或算法实现  微信支付
 */
public class WechatPay extends Payment {
    public String getName() {
        return "微信支付";
    }

    protected double queryBalance(String uid) {
        return 263;
    }
}
