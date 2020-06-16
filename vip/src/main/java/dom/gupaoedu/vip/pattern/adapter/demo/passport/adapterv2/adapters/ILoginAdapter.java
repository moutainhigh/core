package dom.gupaoedu.vip.pattern.adapter.demo.passport.adapterv2.adapters;


import dom.gupaoedu.vip.pattern.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public interface ILoginAdapter {
    boolean support(Object object);

    ResultMsg login(String id, Object adapter);
}
