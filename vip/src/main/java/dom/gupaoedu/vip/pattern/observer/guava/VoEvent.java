package dom.gupaoedu.vip.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Tom.
 */
public class VoEvent {

    // 使用guave注解注册通知到的方法
    @Subscribe
    public void observer(Parpojo arg) {
        System.out.println("班主任收到通知 ：" + arg.getName() + "，成绩：" + arg.getMessage());
    }

}
