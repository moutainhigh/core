package dom.gupaoedu.vip.pattern.state.gper;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        // 默认为未登录状态，会先切换到登陆状态，然后可以正常评论
        context.favorite();
        context.comment("评论：好文章，360个赞");
    }
}
