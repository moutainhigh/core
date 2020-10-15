package com.gupao.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodType;

/**
 * @Titile: IntelliJ IDEA
 * @Description:
 * @Author: mafenglei @Date: 2020/10/15 22:23
 * @Version:1.0
 */
@RestController
public class OrderController {
    @RequestMapping(value = "/order/order1",method = RequestMethod.GET)
    public String order1() {
        return "order1 ....";
    }

    @RequestMapping("/order/order2")
    public String order2() {
        return "order2 ....";
    }

    @RequestMapping("/order/order3")
    public String order3() {
        return "order3 ....";
    }
}
