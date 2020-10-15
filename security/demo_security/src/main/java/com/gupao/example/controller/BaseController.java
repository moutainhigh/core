package com.gupao.example.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 页面跳转
 *
 * @Author: fengleima  2020/10/15 8:53
 */
@Controller
public class BaseController {
    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/")
    public String base() {
        return "/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/failure")
    public String failure() {
        return "/failure";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() + "";
    }
}