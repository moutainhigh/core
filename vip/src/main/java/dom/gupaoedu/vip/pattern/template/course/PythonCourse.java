package dom.gupaoedu.vip.pattern.template.course;

/**
 * 子类具体实现  使用默认的钩子
 */
public class PythonCourse extends AbastractCourse {
    protected void checkHomework() {
        System.out.println("检查Python作业");
    }
}
