package dom.gupaoedu.vip.pattern.strategy.promotion;

/**
 * 团购策略
 */
public class GroupbuyStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("5人成团，可以优惠");
    }
}
