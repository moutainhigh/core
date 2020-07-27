package com.gupaoedu.example.controller;

import com.gupaoedu.example.userserviceprovider.hystrix.GpHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class GpHystrixController {

    @Autowired
    RestTemplate restTemplate;

    @GpHystrixCommand(fallback = "fallback",timeout = 3000)
    @GetMapping("/hystrix/test")
    public String test(){
        return restTemplate.getForObject("http://localhost:8082/orders",String.class);
    }

    public String fallback(){
        return "请求被降级";
    }
}
