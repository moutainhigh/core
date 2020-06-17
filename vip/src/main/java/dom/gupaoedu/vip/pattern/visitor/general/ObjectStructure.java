package dom.gupaoedu.vip.pattern.visitor.general;

import java.util.ArrayList;
import java.util.List;

// 结构对象   该类内部维护了元素集合，并且提供方法接受访问者对该集合所有元素进行操作
public class ObjectStructure {
    private List<IElement> list = new ArrayList<IElement>();

    {
        // 添加访问者可以访问的所有操作
        this.list.add(new ConcreteElementA());
        this.list.add(new ConcreteElementB());
    }

    // 接受访问
    public void accept(IVisitor visitor) {
        for (IElement element : this.list) {
            element.accept(visitor);
        }
    }
}