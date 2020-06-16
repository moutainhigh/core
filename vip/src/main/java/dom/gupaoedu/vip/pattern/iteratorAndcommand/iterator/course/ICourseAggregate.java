package dom.gupaoedu.vip.pattern.iteratorAndcommand.iterator.course;

/**
 * 抽象容器
 */
public interface ICourseAggregate {
    void add(Course course);
    void remove(Course course);
    Iterator<Course> iterator();
}
