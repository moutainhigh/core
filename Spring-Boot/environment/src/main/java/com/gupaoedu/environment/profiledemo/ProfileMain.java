package com.gupaoedu.environment.profiledemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class ProfileMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		// 设置激活的环境为dev
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfiguration.class);
        context.refresh();
        System.out.println(context.getBean(ProfileService.class));
    }
}
