package gupaoedu.vip.pattern.factory.abstractfactory.abstractfactory;


import gupaoedu.vip.pattern.factory.abstractfactory.INote;
import gupaoedu.vip.pattern.factory.abstractfactory.IVideo;
import gupaoedu.vip.pattern.factory.abstractfactory.PythonNote;
import gupaoedu.vip.pattern.factory.abstractfactory.PythonVideo;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new PythonNote();
    }


    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
