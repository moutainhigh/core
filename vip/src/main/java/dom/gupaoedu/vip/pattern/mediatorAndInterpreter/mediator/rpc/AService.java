package dom.gupaoedu.vip.pattern.mediatorAndInterpreter.mediator.rpc;

/**
 * Created by Tom.
 */
public class AService implements IService {
    Registy registy;
    AService(){
        registy.regist("aService",this);
    }

    public void a(){
//        registy.get("bService").xxx();
    }
}
