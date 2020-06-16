package dom.gupaoedu.vip.pattern.state.gper;

/**
 * 具体状态角色：具体实现该状态对应的行为，并且在需要的情况下进行状态的切换。 登陆状态
 */
public class LoginState extends UserState {
    @Override
    public void favorite() {
        System.out.println("收藏成功！");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
