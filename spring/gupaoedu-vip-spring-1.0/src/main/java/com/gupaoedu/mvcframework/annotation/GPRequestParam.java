package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})// 用于描述注解的使用范围
@Retention(RetentionPolicy.RUNTIME)// 定义被它所注解的注解保留多久，在这里注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
@Documented//表明这个注解应该被 javadoc工具记录，该注解将被包含在javadoc中
public @interface GPRequestParam {
    String value() default "";
}
