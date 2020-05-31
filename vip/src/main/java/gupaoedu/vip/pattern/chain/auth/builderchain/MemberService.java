package gupaoedu.vip.pattern.chain.auth.builderchain;


import gupaoedu.vip.pattern.chain.auth.Member;

/**
 * Created by Tom.
 */
public class MemberService {

    public void login(String loginName,String loginPass){

        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        //  builder.build()这里从头部开始添加，把Member对象传递过去，一级一级往下传递，这里就不用next  next
        builder.build().doHandler(new Member(loginName,loginPass));


        //用过Netty的人，肯定见过
    }

}
