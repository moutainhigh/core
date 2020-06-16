package dom.gupaoedu.vip.pattern.strategy.promotion;

/**
 * 具体的策略或算法实现  优惠券策略
 */
public class CouponStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("使用优惠券抵扣");
    }
}
