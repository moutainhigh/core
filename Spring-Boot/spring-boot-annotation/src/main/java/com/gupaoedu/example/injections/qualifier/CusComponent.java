package com.gupaoedu.example.injections.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Qualifier 注解作用：当容器中存在多个相同的类型Bean时，用Qualifier注解进行候选，指定要注入的明确的那个类型
 * 如果在类上或方法上加了@Qualifier 注解，也没有指定注入确定的Bean，就会把所有加了@Qualifier注解的bean都注入过来。
 **/
@Component
public class CusComponent {
    private static final Logger LOGGEER = LoggerFactory.getLogger(CusComponent.class);

    /**
     * 自动装配时，此注释可以在字段或参数上用作候选bean的限定符。它也可以用于注释其他自定义注释，这些注释随后可以用作限定符。
     * spring 默认是单例的，当有一个类型存在时，这里不加Qualifier注解不会报错，
     */
    // 容器中TestClass类有两个，如果这里不加要加载bean的名称，spring就不无法判断，你是要注入两个类中的哪一个，就会报错，
    // 所以这里用Qualifier注解选择要加载的那个bean  证明当容器中存在多个相同的类型Bean时，用Qualifier注解进行候选，指定要注入的明确的那个类型
//    @Qualifier("testClass1")
    @Qualifier("testClass2")
    @Autowired
    private TestClass testClass;


    public void testQualifier() {
        LOGGEER.info(testClass.toString());
    }

}
