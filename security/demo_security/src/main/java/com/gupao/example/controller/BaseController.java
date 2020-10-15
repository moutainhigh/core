package com.gupao.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}