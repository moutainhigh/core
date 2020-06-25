package com.gupaoedu.example.redis.demo04;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Import 作用是导入另外的配置类，从而根据这个配置类中的描述来实现Bean的装配。
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(GpDefineImportSelector.class)
public @interface EnableConfiguration {

}
