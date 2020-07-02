package com.gupaoedu.example.redis.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 探索Spring Boot自动装配的原理
 **/
@SuppressWarnings("ALL")
@RestController
public class HelloController {

    //  我们并没有通过XML形式或者注解形式把RedisTemplage注入IoC容器，但是在类中却
    //  可以直接使用@Autowired来注入redisTemplate实例，说明IoC容器已经存在RedisTemplate。这就是自动装配。
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @GetMapping("/say")
    public String say() {
        return redisTemplate.opsForValue().get("name");
    }

}
