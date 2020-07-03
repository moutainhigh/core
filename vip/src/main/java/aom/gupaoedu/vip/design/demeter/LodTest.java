package aom.gupaoedu.vip.design.demeter;

/**
 * Created by Tom on 2020/2/16.
 */
public class LodTest {

    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader();
        Employee employee = new Employee();
        /** 不符合最少知道原则  */
        //List<Course> courseList = new ArrayList<Course>();
        //for (int i = 0; i < 20; i ++){
        //    courseList.add(new Course());
        //}
//        System.out.println("目前已发布的课程数量为：" + courseList.size());
        /** 上面的动作 我也知道了 */
        teamLeader.commandCheckNumber(employee);
    }
}
