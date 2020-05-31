package gupaoedu.vip.pattern.strategy.promotion;

/**
 * 具体的策略或算法实现  返现策略
 */
public class CashbackStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("返现，直接打款到支付宝账号");
    }
}
