package dom.gupaoedu.vip.pattern.factory.factorymethod.factorymethod;

import dom.gupaoedu.vip.pattern.factory.factorymethod.ICourse;

/**
 * Created by Tom.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {

        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();

    }

}
