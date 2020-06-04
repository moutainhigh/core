package gupaoedu.vip.pattern.template.course;

/**
 * 抽象模板
 */
public abstract class AbastractCourse {

    // 封装固定流程
    public final void createCourse(){
        //1、发布预习资料
        postPreResoucse();
        
        //2、制作课件
        createPPT();
        
        //3、直播授课
        liveVideo();
        
        //4、上传课后资料
        postResource();
        
        //5、布置作业
        postHomework();
        
        if(needCheckHomework()){
            checkHomework();
        }
    }

    // 具体子类去实现
    protected abstract void checkHomework();

    //钩子方法 干预执行流程
    protected boolean needCheckHomework(){return  false;}

    protected void postHomework(){
        System.out.println("布置作业");
    }

    protected void postResource(){
        System.out.println("上传课后资料");
    }

    protected void liveVideo(){
        System.out.println("直播授课");
    }

    protected void createPPT(){
        System.out.println("制作课件");
    }

    protected void postPreResoucse(){
        System.out.println("发布预习资料");
    }

}
