package dom.gupaoedu.vip.pattern.iteratorAndcommand.iterator.course;

/**
 * 抽象迭代器接口：
 */
public interface Iterator<E> {
    // 下一个
    E next();
    // 判断是有下一个元素
    boolean hasNext();
}
