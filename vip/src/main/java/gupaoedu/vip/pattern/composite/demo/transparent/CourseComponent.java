package gupaoedu.vip.pattern.composite.demo.transparent;

/**
 * 抽象节点
 */
public abstract class CourseComponent {

    // 由树节点和叶子节点去实现，如果不实现，对于叶子节点个跟节点都是可见的，违背了最少知道原则，所以不推荐
    public void addChild(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    // 由树节点和叶子节点去实现
    public void removeChild(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除操作");
    }


    public String getName(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }


    public double getPrice(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }


    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
