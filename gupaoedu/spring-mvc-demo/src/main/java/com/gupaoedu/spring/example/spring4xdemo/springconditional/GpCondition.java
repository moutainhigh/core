package com.gupaoedu.spring.example.spring4xdemo.springconditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 条件装配需要实现Condition接口并重写matches方法
 **/
public class GpCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否装载的判断逻辑
        if (1 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
