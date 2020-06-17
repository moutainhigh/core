package dom.gupaoedu.vip.pattern.visitor.general;

/**
 * 抽象访问者
 * 接口或抽象类，该类声明了每一个元素的访问行为，其参数就是具体的元素对象,
 * 如果元素个数经常变动，会导致访问者的方法也要经变动，此时，该情形并不适合访问者模式；
 */
public interface IVisitor {

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}