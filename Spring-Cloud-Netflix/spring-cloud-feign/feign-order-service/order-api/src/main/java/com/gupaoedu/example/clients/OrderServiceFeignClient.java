package com.gupaoedu.example.clients;

import com.gupaoedu.example.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 发布服务
 **/

@FeignClient("order-service")
public interface OrderServiceFeignClient extends OrderService{

}
