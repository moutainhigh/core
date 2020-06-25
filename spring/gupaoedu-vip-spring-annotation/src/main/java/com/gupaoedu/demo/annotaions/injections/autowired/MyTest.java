package com.gupaoedu.demo.annotaions.injections.autowired;


import com.gupaoedu.project.dao.MyDao;
import com.gupaoedu.project.service.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by Tom.
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        Object controller = app.getBean("myController");
        System.out.println(controller);

        MyService service = app.getBean(MyService.class);
        service.print();

        MyDao dao = app.getBean(MyDao.class);
        System.out.println(dao);
    }
}
