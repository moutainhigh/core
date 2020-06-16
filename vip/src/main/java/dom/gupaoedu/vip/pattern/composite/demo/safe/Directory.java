package dom.gupaoedu.vip.pattern.composite.demo.safe;

/**
 * 1、抽象根节点:定义系统各层次对象的共有方法和属性,可以预先定义一些默认行为和属性；
 */
public abstract class Directory {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    // 统一用一个方法来操作
    public abstract void show();

}