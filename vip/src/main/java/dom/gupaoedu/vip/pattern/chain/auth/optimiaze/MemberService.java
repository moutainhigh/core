package dom.gupaoedu.vip.pattern.chain.auth.optimiaze;


import dom.gupaoedu.vip.pattern.chain.auth.Member;

/**
 * Created by Tom.
 */
public class MemberService {

    /**
     * 登录 用责任链模式去处理
     * @param loginName
     * @param loginPass
     */
    public void login(String loginName,String loginPass){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        // 设置下一个形成责任链  这里有个缺点需要调用next下一个，如果当有多个多个的时候，这里代码就要next很多，
        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandler(new Member(loginName,loginPass));

    }

}
