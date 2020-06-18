package dom.gupaoedu.vip.pattern.observer.mouseevent;


import dom.gupaoedu.vip.pattern.observer.mouseevent.handler.Mouse;
import dom.gupaoedu.vip.pattern.observer.mouseevent.handler.MouseEventLisenter;
import dom.gupaoedu.vip.pattern.observer.mouseevent.handler.MouseEventType;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        // 观察者
        MouseEventLisenter lisenter = new MouseEventLisenter();

        // 被观察者
        Mouse mouse = new Mouse();
        // 注册事件
        mouse.addLisenter(MouseEventType.ON_CLICK,lisenter);
        mouse.addLisenter(MouseEventType.ON_MOVE,lisenter);

        // 发布通知
        mouse.click();
        mouse.move();
    }
}
