package gupaoedu.vip.pattern.factory.factorymethod.factorymethod;

import gupaoedu.vip.pattern.factory.factorymethod.ICourse;
import gupaoedu.vip.pattern.factory.factorymethod.JavaCourse;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
