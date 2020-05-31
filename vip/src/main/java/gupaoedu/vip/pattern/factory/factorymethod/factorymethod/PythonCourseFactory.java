package gupaoedu.vip.pattern.factory.factorymethod.factorymethod;

import gupaoedu.vip.pattern.factory.factorymethod.ICourse;
import gupaoedu.vip.pattern.factory.factorymethod.PythonCourse;

/**
 * Created by Tom.
 */
public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
