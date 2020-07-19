package com.gupaoedu.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RefreshScope  // 这个注解的作用是当git上配置文件更新的时候，下面获取的值能实时去刷新 还需要增加依赖，增加配置，发送post请求
@RestController
public class ConfigController {

    //Environement 去获得指定的配置.
    @Value("${hello}")
    private String txt;

    @GetMapping("/config")
    public String config(){
        return txt;
    }

}
