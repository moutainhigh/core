package dom.gupaoedu.vip.pattern.chain.auth.builderchain;


import dom.gupaoedu.vip.pattern.chain.auth.Member;

/**
 * Created by Tom.
 */
public abstract class Handler<T> {
    protected Handler next;
    public void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(Member member);

    // 这里是双向链表
    public static class Builder<T>{
        private Handler<T> head; // 头
        private Handler<T> tail; // 尾

        public Builder<T> addHandler(Handler handler){
//            do {
                // 如果为空的话这里头跟尾是一样的
                if (this.head == null) {
                    this.head = this.tail = handler;
                    return this;
                }
                // 如果不为空的话 这里从tail部开始添加
                this.tail.next(handler);
                // 同时把传递过来的对象设置为尾，刚开始的时候就两个对象，第二个是尾，
                // 当添加第三个的时候，肯定第三个就成为尾了，就用this.tail = handler来往后移动一个，标记尾的位置
                this.tail = handler;
//            }while (false);//真正框架中，如果是双向链表，会判断是否已经到了尾部，如果到了尾部再继续从头开始，这才是真正的双向链表
            return this;
        }

        public Handler<T> build(){
            return this.head;
        }

    }
}
