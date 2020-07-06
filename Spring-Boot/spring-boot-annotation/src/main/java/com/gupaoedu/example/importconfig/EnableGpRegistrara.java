package com.gupaoedu.example.importconfig;

import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * ¶¨Òå×¢½â
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(GpImportBeanDefinitionRegistrar.class)
public @interface EnableGpRegistrara {

}
