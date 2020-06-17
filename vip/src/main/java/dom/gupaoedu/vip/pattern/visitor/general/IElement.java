package dom.gupaoedu.vip.pattern.visitor.general;

// 抽象元素   接口或抽象类，定义了一个接受访问者访问方法，表示所有元素类型都支持被访问者访问；
public interface IElement {
    void accept(IVisitor visitor);
}