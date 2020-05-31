package gupaoedu.vip.pattern.strategy.pay.payport;

/**
 * 具体的策略或算法实现  用户实现的京东白条策略
 */
public class JDPay extends Payment {
    public String getName() {
        return "京东白条";
    }

    protected double queryBalance(String uid) {
        return 500;
    }
}
