package com.gupaoedu.example.customeractuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义监控信息，然后让boot集成
 * 访问 http://localhost:8080/actuator/customer
 **/
@Endpoint(id = "customer")
public class CustomerMetricsIndicator {

    @ReadOperation
    public Map<String, Object> time() {
        Map<String, Object> result = new HashMap<>();
        Date time = new Date();
        result.put("当前时间:", time.toString());
        return result;
    }

}
