package gupaoedu.vip.pattern.strategy.pay.payport;

/**
 *  具体的策略或算法实现 用户实现的支付宝策略
 */
public class AliPay extends Payment {
    public String getName() {
        return "支付宝";
    }

    protected double queryBalance(String uid) {
        return 900;
    }
}
