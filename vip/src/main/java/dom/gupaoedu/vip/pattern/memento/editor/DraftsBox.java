package dom.gupaoedu.vip.pattern.memento.editor;

import java.util.Stack;

/**
 * 备忘录管理员角色：负责存储，提供管理备忘，无法对备忘内容进行操作和访问。
 */
public class DraftsBox {
    private final Stack<ArticleMemento> STACK = new Stack<ArticleMemento>();

    // 从备忘录恢复
    public ArticleMemento getMemento() {
        // pop 移除堆栈顶部的对象，并作为此函数的值返回该对象。
        ArticleMemento articleMemento = STACK.pop();
        return articleMemento;
    }

    // 创建一个备忘录
    public void addMemento(ArticleMemento articleMemento) {
        STACK.push(articleMemento);
    }

}
