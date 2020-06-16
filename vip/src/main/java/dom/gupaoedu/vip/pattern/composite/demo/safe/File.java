package dom.gupaoedu.vip.pattern.composite.demo.safe;

/**
 * 3、叶子节点:叶子节点对象,其下再无分支,是系统层次遍历的最小单位。
 */
public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }

}