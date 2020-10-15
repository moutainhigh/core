package com.gupao.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @Titile: IntelliJ IDEA
 * jsr250-api的注解开启权限
 * @Author: mafenglei @Date: 2020/10/15 23:06
 * @Version:1.0
 */
@RestController
public class PersonController {

    @RolesAllowed({"USER"})
    @RequestMapping("/hello1")
    public String hello1() {
        return "hello1 ..."; // 具有权限
    }

    @RolesAllowed({"ROOT"})
    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2 ..."; // 没有权限
    }

    @RequestMapping("/hello3")
    public String hello3() {
        return "hello3 ...";
    }
}
