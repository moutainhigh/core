package dom.gupaoedu.vip.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Tom.
 */
public class PojoEvent {

    // 使用guave注解注册通知到的方法
    @Subscribe
    public void observer(Parpojo pojo) {
        System.out.println("校长收到通知 ：" + pojo.getName() + "，成绩：" + pojo.getMessage());
    }

}
