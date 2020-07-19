package com.gupaoedu.environment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@RestController
@RequestMapping("/user")
public class ConfigController {

    @Value("${custom.property.hello}")
	//@Value("${env}")
    private String txt;

    @Autowired
    Environment environment;

    @GetMapping("/config")
    public String config(){
        return txt;
    }
	
	@GetMapping("/tt")
    public String configtest(){
        return environment.getProperty("java.version");
    }

    @GetMapping("/en")
    public String testProfile(){
        return environment.getProperty("envt");
    }
}
