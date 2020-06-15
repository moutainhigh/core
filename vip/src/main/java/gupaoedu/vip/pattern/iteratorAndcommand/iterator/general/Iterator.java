package gupaoedu.vip.pattern.iteratorAndcommand.iterator.general;

//抽象迭代器
public interface Iterator<E> {

    E next();

    boolean hasNext();
}