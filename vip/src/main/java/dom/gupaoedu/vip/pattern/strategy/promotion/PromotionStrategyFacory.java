package dom.gupaoedu.vip.pattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 上下文(桥接)  用来操作策略的上下文环境，屏蔽高层模块（客户端）对策略，算法的直接访问，封装可能存在的变化；
 */
public class PromotionStrategyFacory {

    // 所有的策略
    private static Map<String,IPromotionStrategy> PROMOTIONS = new HashMap<String,IPromotionStrategy>();

    // 初始化
    static {
        PROMOTIONS.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK,new CashbackStrategy());// 返现
        PROMOTIONS.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());// 团购
    }

    // 默认的策略
    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    private PromotionStrategyFacory(){}

    // 根据用户选择得到想要的策略
    public static IPromotionStrategy getPromotionStrategy(String promotionKey){
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY : strategy;
    }
    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }

    public static  Set<String> getPromotionKeys(){
        return PROMOTIONS.keySet();
    }
}
