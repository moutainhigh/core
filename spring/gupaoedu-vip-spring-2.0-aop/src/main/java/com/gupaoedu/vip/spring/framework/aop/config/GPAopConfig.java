package com.gupaoedu.vip.spring.framework.aop.config;

import lombok.Data;

/**
 * https://blog.csdn.net/qq_34129814/article/details/90376921  解决Intellij使用Lombok报错
 * https://blog.csdn.net/daisy_zhangy/article/details/89873972  Lombok使用简介
 */
@Data
public class GPAopConfig {
    private String pointCut;
    private String aspectClass;
    private String aspectBefore;
    private String aspectAfter;
    private String aspectAfterThrow;
    private String aspectAfterThrowingName;
}
