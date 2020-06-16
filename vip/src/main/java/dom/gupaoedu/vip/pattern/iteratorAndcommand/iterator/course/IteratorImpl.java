package dom.gupaoedu.vip.pattern.iteratorAndcommand.iterator.course;

import java.util.List;

/**
 * 具体迭代器实现
 */
public class IteratorImpl<E> implements Iterator<E> {
    // 存到元素的集合
    private List<E> list;
    // 当前元素的游标
    private int cursor;
    // 当前元素
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    public E next() {
        System.out.print("当前位置 " + cursor + " : ");
        element = list.get(cursor);
        cursor++;
        return element;
    }

    public boolean hasNext() {
        if (cursor > list.size() - 1) {
            return false;
        }
        return true;
    }
}
