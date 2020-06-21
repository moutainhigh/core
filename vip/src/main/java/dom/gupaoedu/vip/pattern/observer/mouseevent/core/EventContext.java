package dom.gupaoedu.vip.pattern.observer.mouseevent.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 具体被观察者，当内部状态变化时，会通知已注册的所有观察者；
 */
public class EventContext {
    // 注册的所有事件
    protected Map<String, Event> events = new HashMap<String, Event>();

    /**
     * 注册事件
     *
     * @param eventType 事件类型
     * @param target    观察者
     */
    public void addLisenter(String eventType, EventListener target) {
        try {
            // 得到类，再得到方法 参数： 方法名 方法的参数
            this.addLisenter(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            return;
        }
    }

    // 注册事件  target 观察者 ; callback 观察者要调用的方法
    public void addLisenter(String eventType, EventListener target, Method callback) {
        events.put(eventType, new Event(target, callback));
    }


    /**
     * 发布通知事件
     *
     * @param trigger 事件类型
     */
    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            System.out.println("事件类型未注册");
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }

    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            if (event.getCallback() != null) {
                //用反射调用回调函数  传两个参数，1个是调用的那个类，参数
                event.getCallback().invoke(event.getTarget(), event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 首字母大写
     *
     * @param eventType
     * @return
     */
    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
