package gupaoedu.vip.pattern.strategy.pay.payport;

/**
 * 具体的策略或算法实现  用户实现的银联支付策略
 */
public class UnionPay extends Payment {
    public String getName() {
        return "银联支付";
    }

    protected double queryBalance(String uid) {
        return 120;
    }
}
