package com.gupaoedu.example.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明这个注解之后，自动发布使用注解的类下面的所有的方法服务
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component  //被Spring扫描到
public @interface GpRemoteService {

}
