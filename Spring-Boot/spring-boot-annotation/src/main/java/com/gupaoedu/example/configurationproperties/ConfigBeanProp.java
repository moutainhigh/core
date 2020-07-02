package com.gupaoedu.example.configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/2 14:44
 * @Version:1.0
 */
@Data
@ConfigurationProperties(prefix = "gp.redisson")// ������properties�ļ�������һ��Bean����������������Ӷ�ʵ�����Ͱ�ȫ�����á�
//@PropertySource(value = {"classpath:/application.properties"})// ָ���ļ���ַ�����ڼ����ļ�������Ϣ��Ҳ���Բ���ָ��
public class ConfigBeanProp {
    private String host;
    private String password;
    private int port;
    private int timeout;
    private boolean ssl;
}
