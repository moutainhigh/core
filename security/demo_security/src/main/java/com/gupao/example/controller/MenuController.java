package com.gupao.example.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringSecurity提供的权限注解使用
 *
 * @Author: mafenglei @Date: 2020/10/15 23:16
 * @Version:1.0
 */
@RestController
public class MenuController {
    @Secured({"ROLE_USER"})
    @RequestMapping("/fun1")
    public String fun1() {
        return "fun1 ..."; // 可以访问
    }

    @Secured({"ROLE_ROOT"})
    @RequestMapping("/fun2")
    public String fun2() {
        return "fun2 ..."; // 不能访问
    }

    @RequestMapping("/fun3")
    public String fun3() {
        return "fun3 ...";
    }
}
