package com.gupaoedu.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 手写 redis 单机组件
 **/
@ConditionalOnClass(Redisson.class) //条件装配 如果classpath下存在Redisson时，则将RedissonAutoConfiguration进行装配
// @EnableConfigurationProperties注解作用：自动将类RedissonProperties进行装配
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {

    @Bean
    public RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = "redis://";

        // 是否加密判断
        if (redissonProperties.isSsl()) {
            prefix = "rediss://";
        }
        // 这里是单机的
        config.useSingleServer().
                setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort()).
                setConnectTimeout(redissonProperties.getTimeout());
        System.out.println("手写 redis 单机 starter组件");
        return Redisson.create(config);
    }
}
