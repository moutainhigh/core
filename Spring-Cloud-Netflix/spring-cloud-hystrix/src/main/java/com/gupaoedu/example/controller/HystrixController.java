package com.gupaoedu.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 熔断开启后，后续正常请求也无法发起访问
 * 10秒之内你发起20个请求，失败率超过50%,就会触发熔断，熔断的恢复时间5秒
 * 从熔断开启到后续5s之内的请求，都不会发起到远程服务器端。
 *
 * 默认是关闭的
 * http://localhsot:8081/hystrix/order/1   访问多次后 触发熔断，然后在访问下面的2地址，发现2也不能访问了，过了会2又能访问了
 * http://localhsot:8081/hystrix/order/2
 **/
@DefaultProperties(defaultFallback = "fallback")
@RestController
public class HystrixController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 熔断触发降级
     * @param num
     * @return
     */
    // HystrixCommandProperties 配置类
    // 出现问题后调用fallback回退方法
    @HystrixCommand(commandProperties = {
            // true 为开启熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 最小请求数目
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            // 熔断的时间5秒
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
            // 百分比(50%)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    }, fallbackMethod = "fallback", groupKey = "", threadPoolKey = "order-service")
    @GetMapping("/hystrix/order/{num}")
    public String queryOrder(@PathVariable("num") int num) {
        // 熔断开启后，后续正常请求也无法发起访问
        if (num % 2 == 0) {
            return "正常访问";
        }
        //restTemplate默认有一个请求超时时间
        return restTemplate.getForObject("http://localhost:8082/orders", String.class);
    }


    /**
     * 超时触发降级  默认为1秒，所以这里配置为3秒
     */
    @HystrixCommand(fallbackMethod = "timeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
    })
    @GetMapping("/hystrix/timeout")
    public String queryOrderTimeout() {
        return restTemplate.getForObject("http://localhost:8082/orders", String.class);
    }


    // 方法名 参数要保持一致
    public String fallback(int num) {
        // 兜底可以在这里完成
        return "系统繁忙";
    }

    public String timeoutFallback(int num) {
        // 兜底可以在这里完成
        return "请求超时";
    }

}
