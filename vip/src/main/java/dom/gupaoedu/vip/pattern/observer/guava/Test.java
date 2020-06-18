package dom.gupaoedu.vip.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // guave内置观察者
        EventBus eventBus = new EventBus();

        // 观察者
        PojoEvent guavaEvent = new PojoEvent();
        VoEvent voEvent = new VoEvent();

        // 观察者注册
        eventBus.register(guavaEvent);

        eventBus.register(voEvent);

        // 用户行为
        Parpojo parpojo = new Pojo("Tom", "96");
        System.out.println("Tom 成绩录入完成\r\n===================================");
        // 通知
        eventBus.post(parpojo);
    }
}

