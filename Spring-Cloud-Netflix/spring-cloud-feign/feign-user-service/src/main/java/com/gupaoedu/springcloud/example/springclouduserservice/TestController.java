package com.gupaoedu.springcloud.example.springclouduserservice;

import com.gupaoedu.example.clients.OrderServiceFeignClient;
import com.gupaoedu.example.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class TestController {

    @Autowired
    OrderServiceFeignClient orderServiceFeignClient; //动态代理

    @GetMapping("/test")
    public String test(){
        return orderServiceFeignClient.orders();
    }

    @PostMapping("/test")
    public String insert(){
        OrderDto orderDto=new OrderDto();
        return orderServiceFeignClient.insert(orderDto)+"";
    }
}
