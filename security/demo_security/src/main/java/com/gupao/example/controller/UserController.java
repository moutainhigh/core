package com.gupao.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Titile: IntelliJ IDEA
 * @Description:Spring表达式注解中开启权限使用
 * @Author: mafenglei @Date: 2020/10/15 22:58
 * @Version:1.0
 */
@Controller
public class UserController {
    @PreAuthorize(value = "hasRole('USER')")
    @GetMapping("/query1")
    public String query1() {
        System.out.println("query1 ....");
        return "/home";
    }

    @PreAuthorize(value = "hasRole('ROOT')")
    @GetMapping("/query2")
    public String query2() {
        System.out.println("query2 ....");
        return "/home";
    }

    @PreAuthorize(value = "hasRole('ROOT') OR hasRole('USER')")
    @GetMapping("/query3")
    public String query3() {
        System.out.println("query3 ....");
        return "/home";
    }
}
