package com.gupaoedu.example.importconfig;

import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * 定义注解
 **/
@Retention(RetentionPolicy.RUNTIME) //保留时间，这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
@Target(ElementType.TYPE)
@Documented  //有关java doc的注解
@Import(GpImportBeanDefinitionRegistrar.class)
public @interface EnableGpRegistrara {

}
