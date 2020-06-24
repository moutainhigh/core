package com.gupaoedu.example.rcp.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明注解  只要加了这个注解，就给会类做一个代理
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface GpReference {
}
