package dom.gupaoedu.vip.pattern.factory.factorymethod.factorymethod;

import dom.gupaoedu.vip.pattern.factory.factorymethod.ICourse;
import dom.gupaoedu.vip.pattern.factory.factorymethod.PythonCourse;

/**
 * Created by Tom.
 */
public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
