package gupaoedu.vip.pattern.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 卖票共享池业务  享元模式 享元工厂
 */
class TicketFactory {
    private static Map<String, ITicket> sTicketPool = new ConcurrentHashMap<String,ITicket>();

    /**
     * 将对象集中缓存起来，下次使用直接从共享池里面拿
     */
    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        // 共享池如果有对象直接使用
        if (TicketFactory.sTicketPool.containsKey(key)) {
            System.out.println("使用缓存：" + key);
            return TicketFactory.sTicketPool.get(key);
        }
        // 共享池如果没有直接将对象放到共享池
        System.out.println("首次查询，创建对象: " + key);
        ITicket ticket = new TrainTicket(from, to);
        TicketFactory.sTicketPool.put(key, ticket);
        return ticket;
    }
}