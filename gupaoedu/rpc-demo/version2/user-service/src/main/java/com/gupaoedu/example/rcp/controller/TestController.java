package com.gupaoedu.example.rcp.controller;

import com.gupaoedu.example.IOrderService;
import com.gupaoedu.example.ITestService;
import com.gupaoedu.example.rcp.annotation.GpReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@RestController
public class TestController {

    //程序启动会没每一个使用此注解的类使用一个代理
    @GpReference
    private IOrderService orderService;
    @GpReference
    private ITestService testService;

    @GetMapping("/test")
    public String test(){
        return orderService.queryOrderList();
    }

    @GetMapping("/get")
    public String get(){
        return testService.sayHello();
    }


}
