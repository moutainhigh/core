package aom.gupaoedu.vip.design.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 2020/2/16.
 */
public class Employee {

    public void checkNumberOfCourses(){
        /** 逻辑放到我自己的里面，这样别人就不知道我做了什么 */
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i ++){
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量为：" + courseList.size());
    }
}
