package com.gupaoedu.spring.example.vip.spring.framework.aop.config;

import lombok.Data;

/**
 * https://blog.csdn.net/qq_34129814/article/details/90376921  ���Intellijʹ��Lombok����
 * https://blog.csdn.net/daisy_zhangy/article/details/89873972  Lombokʹ�ü��
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
