package com.gupaoedu.demo03;

import com.gupaoedu.demo03.otherconfig.ImportConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring 3.x 去xml化，通过spirng注解驱动去加载bean
 **/
@ComponentScan("com.gupaoedu.demo03")   // 等同于<context:component-scan base-package="com.gupaoedu"/>
@Configuration  //<applicationContext.xml
@Import(ImportConfiguration.class) // 加载另外一个配置文件 动态导入
public class SpringConfiguration {

    @Bean    // 等同于<bean>
    public Demo04Service demo04Service(Demo03Service demo03Service) {
        Demo04Service demo04Service = new Demo04Service();
        demo04Service.setDemo03Service(demo03Service);
        return demo04Service;
    }

}
