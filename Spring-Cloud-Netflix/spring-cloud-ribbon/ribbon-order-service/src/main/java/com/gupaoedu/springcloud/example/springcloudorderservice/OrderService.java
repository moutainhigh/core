package com.gupaoedu.springcloud.example.springcloudorderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class OrderService {

    @Value("${server.port}")
    private int port;

    @GetMapping("/orders")
    public String getAllOrder(){
        System.out.println("port:"+port);
        System.out.println("=============");
        return "Return All Order";
    }
}
