package com.gupaoedu.springcloud.clients;

import com.gupaoedu.springcloud.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@FeignClient("order-service")
public interface OrderServiceFeignClient extends OrderService{

}
