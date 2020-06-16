package dom.gupaoedu.vip.pattern.chain.auth.optimiaze;


import dom.gupaoedu.vip.pattern.chain.auth.Member;
import org.apache.commons.lang3.StringUtils;

/**
 * 校验处理
 */
public class ValidateHandler extends Handler {
    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getLoginName()) ||
                StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        // 交给下一个去处理
        next.doHandler(member);
    }
}
