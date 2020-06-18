package dom.gupaoedu.vip.pattern.observer.mouseevent.handler;


import dom.gupaoedu.vip.pattern.observer.mouseevent.core.Event;
import dom.gupaoedu.vip.pattern.observer.mouseevent.core.EventListener;

/**
 * 具体观察者 在得到状态更新时，会自动做出响应。要通知的对象
 * Created by Tom.
 */
public class MouseEventLisenter implements EventListener {

    /** 观察者收到通知后调用的方法 */
    public void onClick(Event e) {
        System.out.println("==========触发鼠标单击事件========\n" + e);
    }

    /** 观察者收到通知后调用的方法 */
    public void onMove(Event e) {

        System.out.println("==========触发鼠标移动事件========\n" + e);
    }
}
