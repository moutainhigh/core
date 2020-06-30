package com.gupaoedu.example;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用Redis客户端  http://localhost:8080/say
 **/
@RestController
public class StarterTestController {

    @Autowired
    RedissonClient redissonClient;

    @GetMapping("/say")
    public String say() {
        RBucket bucket = redissonClient.getBucket("name");
        if (bucket.get() == null) {
            bucket.set("gupaoedu.com");
        }
        return bucket.get().toString();
    }
}
