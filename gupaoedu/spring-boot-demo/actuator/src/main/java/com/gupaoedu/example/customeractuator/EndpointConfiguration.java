package com.gupaoedu.example.customeractuator;

import com.gupaoedu.example.customeractuator.CustomerMetricsIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 增加自定义监控的增加配置，让自定的bean装配到spring容器中
 **/
@Configuration
public class EndpointConfiguration {

    @Bean
    public CustomerMetricsIndicator customerMetricsIndicator() {
        return new CustomerMetricsIndicator();
    }
}
