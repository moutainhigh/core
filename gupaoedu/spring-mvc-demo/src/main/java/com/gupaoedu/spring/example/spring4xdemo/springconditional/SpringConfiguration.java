package com.gupaoedu.spring.example.spring4xdemo.springconditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Spring4.x版本中的注解  @Conditional  条件装配  满足条件的时候去装载，不满足条件则不装载
 **/
@Configuration
public class SpringConfiguration {

    /**
     * spring中的注解
     * 满足条件的时候去装载，不满足条件则不装载
     * 是否需要装载需要类去实现Condition接口并重写matches方法，在方法中实现是否装载逻辑
     */
    // 当spring扫描类的时候发现有@Conditional注解，拿到注解得到类去实例化的时候，就会反射
    // 去调用matches方法，根据matches方法的返回值true和fasle去决定是否装载
    @Conditional(GpCondition.class)
    @Bean
    public DemoService demoService() {
        // 根据判断条件决定是否要装载DemoService
        return new DemoService();
    }
}
