package com.gupaoedu.example.importconfig;

import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * ����ע��
 **/
@Retention(RetentionPolicy.RUNTIME) //����ʱ�䣬�������͵�Annotations����JVM����,����������������ʱ��JVM������ʹ�÷�����ƵĴ�������ȡ��ʹ��.
@Target(ElementType.TYPE)
@Documented  //�й�java doc��ע��
@Import(GpImportBeanDefinitionRegistrar.class)
public @interface EnableGpRegistrara {

}
