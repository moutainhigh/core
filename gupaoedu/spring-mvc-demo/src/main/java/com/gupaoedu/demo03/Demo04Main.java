package com.gupaoedu.demo03;

import com.gupaoedu.demo03.otherconfig.ImportConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 3.x 去xml化
 * http://www.gupaoedu.com
 **/
public class Demo04Main {

    public static void main(String[] args) {
        // 基于注解形式的形式去加载上下文  AnnotationConfigApplicationContext
        ApplicationContext applicationContext=new
                AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println(applicationContext.getBean(Demo03Service.class));

        System.out.println(applicationContext.getBean(ImportConfiguration.class));
    }
}
