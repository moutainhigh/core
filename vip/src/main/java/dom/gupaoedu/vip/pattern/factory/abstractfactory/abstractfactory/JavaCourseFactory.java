package dom.gupaoedu.vip.pattern.factory.abstractfactory.abstractfactory;



import dom.gupaoedu.vip.pattern.factory.abstractfactory.INote;
import dom.gupaoedu.vip.pattern.factory.abstractfactory.IVideo;
import dom.gupaoedu.vip.pattern.factory.abstractfactory.JavaNote;
import dom.gupaoedu.vip.pattern.factory.abstractfactory.JavaVideo;

/**
 * Created by Tom.
 */
public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
