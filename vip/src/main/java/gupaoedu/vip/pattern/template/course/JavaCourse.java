package gupaoedu.vip.pattern.template.course;

/**
 * 子类具体实现
 */
public class JavaCourse extends AbastractCourse {
    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    // 重写钩子方法
    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }
    // 具体实现
    protected void checkHomework() {
        System.out.println("检查Java作业");
    }
}
