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
@ConfigurationProperties(prefix = "gp.redisson")// 将配置properties文件属性与一个Bean及其属性相关联，从而实现类型安全的配置。
//@PropertySource(value = {"classpath:/application.properties"})// 指定文件地址，用于加载文件内容信息。也可以不用指定
public class ConfigBeanProp {
    private String host;
    private String password;
    private int port;
    private int timeout;
    private boolean ssl;
}
