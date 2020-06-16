package dom.gupaoedu.vip.pattern.observer.mouseevent;


import dom.gupaoedu.vip.pattern.observer.mouseevent.handler.Mouse;
import dom.gupaoedu.vip.pattern.observer.mouseevent.handler.MouseEventLisenter;
import dom.gupaoedu.vip.pattern.observer.mouseevent.handler.MouseEventType;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        MouseEventLisenter lisenter = new MouseEventLisenter();

        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK,lisenter);
        mouse.addLisenter(MouseEventType.ON_MOVE,lisenter);

        mouse.click();
        mouse.move();
    }
}
