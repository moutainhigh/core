package gupaoedu.vip.pattern.factory.abstractfactory.abstractfactory;


import gupaoedu.vip.pattern.factory.abstractfactory.INote;
import gupaoedu.vip.pattern.factory.abstractfactory.IVideo;

/**
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展, 大家共有的逻辑功用，具体实现由子类是做
 * Created by Tom.
 */
public abstract class CourseFactory {

    // 共有的逻辑
    public void init(){
        System.out.println("初始化基础数据");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();

}
