package dom.gupaoedu.vip.pattern.strategy.promotion;

/**
 * 具体的策略或算法实现  默认的策略
 */
public class EmptyStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("无优惠");
    }
}
