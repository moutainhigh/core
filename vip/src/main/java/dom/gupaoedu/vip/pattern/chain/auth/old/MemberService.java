package dom.gupaoedu.vip.pattern.chain.auth.old;



import dom.gupaoedu.vip.pattern.chain.auth.Member;
import org.apache.commons.lang3.StringUtils;


/**
 * 没使用责任链模式的代码
 */
public class MemberService {

    /***
     * 这里代码写的一点不优雅  我们可以形成一个链表来处理
     * @param loginName
     * @param loginPass
     */
    public void login(String loginName,String loginPass){
        if(StringUtils.isEmpty(loginName) ||
                StringUtils.isEmpty(loginPass)){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");

        Member member = checkExists(loginName,loginPass);
        if(null == member){
            System.out.println("用户不存在");
            return;
        }
        System.out.println("登录成功！");

        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");

    }

    private Member checkExists(String loginName,String loginPass){
        Member member = new Member(loginName,loginPass);
        member.setRoleName("管理员");
        return member;
    }

    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.login("tom","666");
    }

}
