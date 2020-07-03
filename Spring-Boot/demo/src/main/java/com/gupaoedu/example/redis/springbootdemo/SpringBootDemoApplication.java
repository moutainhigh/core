package com.gupaoedu.example.redis.springbootdemo;


import com.gupaoedu.autoconfiguration.demo.GupaoEduCore;
import com.gupaoedu.example.configures.condition.conditionalonclass.BeanClass;
import com.gupaoedu.example.redis.demo02.GpRedisTemplate;
import com.gupaoedu.example.redis.demo02.RedisConfiguration;
import com.gupaoedu.example.redis.demo03.GpSqlSessionFactory;
import com.gupaoedu.example.redis.demo03.MybatisConfiguration;
import com.gupaoedu.example.redis.demo04.EnableConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot只会扫描启动入口同级目录下的所有包及其子包，这就是为什么都放在主目录位置的原因
 * 这里的启动放在了目录中，所以注释掉@EnableConfiguration 就会报错提示找不到类
 * 使用  ImportSelector 实现批量扫描 实现包的批量扫描
 * 这里使用了EnableConfiguration注解，而此注解中使用了@import，类中实现了动态导入bean，所以就能够扫描到了
 */
@EnableConfiguration
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ca = SpringApplication.run(SpringBootDemoApplication.class, args);

        // 验证手写的批量扫描是否成功
        System.out.println(ca.getBean(GpSqlSessionFactory.class));

        System.out.println(ca.getBean(GpRedisTemplate.class));
        System.out.println(ca.getBean(MybatisConfiguration.class));
        System.out.println(ca.getBean(RedisConfiguration.class));

        // 验证手写的starer是否成功调用
        GupaoEduCore bean = ca.getBean(GupaoEduCore.class);
        System.out.println(bean.study());

        // 验证手写的starer组件2是否成功调用
        BeanClass bean1 = ca.getBean(BeanClass.class);
        bean1.print();
        System.out.println(bean1);
    }
}
