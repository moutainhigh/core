package dom.gupaoedu.vip.pattern.factory.factorymethod.factorymethod;

import dom.gupaoedu.vip.pattern.factory.factorymethod.JavaCourse;
import dom.gupaoedu.vip.pattern.factory.factorymethod.ICourse;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
