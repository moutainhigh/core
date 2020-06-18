package dom.gupaoedu.vip.pattern.visitor.kpi;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        BusinessReport report = new BusinessReport(); // 结构对象
        System.out.println("==========CEO看报表===============");
        report.showReport(new CEOVistitor()); //CEO去访问

        System.out.println("==========CTO看报表===============");
        report.showReport(new CTOVistitor()); // CET去访问
    }
}
