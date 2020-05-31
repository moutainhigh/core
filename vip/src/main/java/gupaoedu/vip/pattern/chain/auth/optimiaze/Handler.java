package gupaoedu.vip.pattern.chain.auth.optimiaze;


import gupaoedu.vip.pattern.chain.auth.Member;

/**
 * Created by Tom.
 */
public abstract class Handler {
    // 下一个是谁
    protected Handler next;
    // 设置下一个  这里是单向链表
    public void next(Handler next){ this.next = next;}

    // 具体的处理方法   由具体的处理对象去处理
    public abstract void doHandler(Member member);
}
