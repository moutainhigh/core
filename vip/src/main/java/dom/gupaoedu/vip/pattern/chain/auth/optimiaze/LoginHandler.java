package dom.gupaoedu.vip.pattern.chain.auth.optimiaze;


import dom.gupaoedu.vip.pattern.chain.auth.Member;

/**
 * 登录处理
 */
public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        // 交给下一个去处理
        next.doHandler(member);
    }
}
