package gupaoedu.vip.pattern.factory.simplefactory;


import java.util.Calendar;

/**
 * 小作坊式的工厂模型
 * Created by Tom.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        /**
         * 工厂一方法使用 不管实现再怎么变化，这里基本不变，只需要传一个标识记性，这就是
         * 工厂，具体如何创建只有工厂知道，但是这里标识有可能传错，所以在升级到工厂二
         * */
//        ICourse course = new CourseFactory().create("java");
//        course.record();


        /** 工厂二方法使用 只不过这里工厂实现用了反射，但可能还会传错字符串 */
//        ICourseFactory factory = new ICourseFactory();
//        ICourse course = factory.create("com.gupaoedu.vip.pattern.factory.JavaCourse");
//        course.record();

        /**
         * 工厂四方法使用  强烈推荐
         */
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();

        // java内置日历就使用了简单工厂模式
//        Calendar.getInstance();

    }
}
