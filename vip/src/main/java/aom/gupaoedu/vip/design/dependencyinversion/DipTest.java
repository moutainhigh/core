package aom.gupaoedu.vip.design.dependencyinversion;

/**
 * Created by Tom on 2020/2/16.
 */
public class DipTest {

    public static void main(String[] args) {
        //=====  V1  ========
//        Tom tom = new Tom();
//        tom.studyJavaCourse();
//        tom.studyPythonCourse();
//        tom.studyAICourse();


        //=====  V2  ========
//        Tom tom = new Tom();
//        tom.study(new JavaCourse());
//        tom.study(new PythonCourse());


        //=====  V3  ========
//        Tom tom = new Tom(new JavaCourse());
//        tom.study();


        //=====  V4  ========
        // Spring中好多都是怎么干的，依赖倒置原则
        Tom tom = new Tom();
        tom.setiCourse(new JavaCourse());
        //study方法的具体实现依赖于抽象 JavaCourse
        tom.study();
    }
}
