package dom.gupaoedu.vip.pattern.state.gper;

/**
 * 抽象状态角色：定义该状态下的行为，可以有一个或多个行为；
 */
public abstract class UserState {
    // 上下文 复制状态的切换
    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    // 收藏
    public abstract void favorite();

    // 评论
    public abstract void comment(String comment);
}
