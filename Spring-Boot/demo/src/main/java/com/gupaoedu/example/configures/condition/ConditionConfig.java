package com.gupaoedu.example.configures.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

/**
 * ConditionalOnProperty 注解使用
 * <p>
 * 通过其两个属性name以及havingValue来实现的，其中name用来从application.properties中读取某个属性值。
 * 如果该值为空，则返回false;
 * 如果值不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。
 * 如果返回值为false，则该configuration不生效；为true则生效。
 *
 * @Author: mafenglei @Date: 2020/6/26 16:36
 */

//@ConditionalOnProperty(value = "gp.bean.enable", havingValue = "true", matchIfMissing = true)
//@ConditionalOnProperty(prefix = "gp.bean", name = "enable", havingValue = "true")

//在application.properties配置"gp.bean.enable.assert"，对应的值为true
//@ConditionalOnProperty(prefix = "gp.bean.enable", name = "assert", havingValue = "true")

//@Configuration
//@ConditionalOnBean(BeanDemo.class)

// @ConditionalOnClass 表示一个条件，当BeanDemo类存在的时候，ConditionConfig才会被装载
@ConditionalOnClass(BeanDemo.class)
public class ConditionConfig {

    @Bean
    public BeanDemo beanDemo() {
        return new BeanDemo();
    }
}
