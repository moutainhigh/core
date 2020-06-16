package dom.gupaoedu.vip.pattern.state.gper;

/**
 * 具体状态角色：具体实现该状态对应的行为，并且在需要的情况下进行状态的切换。 未登陆状态
 */
public class UnLoginState extends UserState {

    // 未登陆状态不能收藏，先要切换到登陆状态，登陆成功以后才可以收藏
    @Override
    public void favorite() {
        this.switch2login();
        this.context.getState().favorite();
    }

    // 未登陆状态不能评论，先要切换到登陆状态，登陆成功以后才可以评论
    @Override
    public void comment(String comment) {
        this.switch2login();
        this.context.getState().comment(comment);
    }

    private void switch2login() {
        System.out.println("跳转到登录页！");
        this.context.setState(this.context.STATE_LOGIN);
    }
}
