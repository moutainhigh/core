package com.gupaoedu.example.configures.condition.conditionalonbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ConditionalOnBean注解的作用是 容器中存在某个Bean时, 则进行当前Bean的装载(实例化)。
 *
 * @Author: fengleima  2020/7/2 12:33
 */
@Configuration
public class Config {

    // Bean 的名字为city
    @Bean
    public City city() {
        City city = new City();
        System.out.println("千岛湖");
        city.setCityName("千岛湖");
        return city;
    }

    /**
     * 这里加了ConditionalOnBean注解，就代表如果city存在才实例化people
     * 第一次运行 是OK的，所用存在city的Bean,然后把上面的 city方法，变成city1(),运行则报错，
     * 说明@ConditionalOnBean注解的作用是  容器中存在某个Bean时,则进行当前Bean的装载(实例化)。
     */
    @Bean
    @ConditionalOnBean(name = "city")
    public People people(City city) { // 上面City已经装载到容器了，这里会自动注入  或者public People people(city())
        //这里如果city实体没有成功注入 这里就会报空指针
        city.setCityCode(301701);
        city.getCityCode();
        new People();
        return new People("小小", 3, city);
    }
}
