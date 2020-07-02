package com.gupaoedu.example.redis.demo04;


import com.gupaoedu.example.redis.demo02.RedisConfiguration;
import com.gupaoedu.example.redis.demo03.MybatisConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 使用  ImportSelector 实现批量扫描 实现包的批量扫描
 **/
public class GpDefineImportSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //动态导入bean, 告诉了Spring  ， 两个配置类在哪里，就会动态加载不同目录下的配置文件

        //TODO 在这里可以实现加载所有的配置类，只要通过某种机制去完成指定路径的配置类的扫描就行
        // 所以SpringBoot定义了一种标准/规范，第三方的所有Starter组件的配置文件都放在classpath:META-INF/spring.factories
        // 第三方的每个包下面都有这个配置文件，SpringBoot只要需扫描classpath*：META-INF/spring.factories，就能自动装载第三方的Bean了
        // 告诉Spring当前的配置类在哪里，
        //package.class.classname
        // 传入需要导入的配置文件或者bean
        return new String[]{MybatisConfiguration.class.getName(), RedisConfiguration.class.getName()};
    }
}
