package com.gupaoedu.springcloud.example.springclouduserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon客户端负载均衡的使用
 **/
@SuppressWarnings("ALL")
@RestController
public class UserController {

    // RestTemplate实际上是对HttpClient的封装,实现远程调用
    @Autowired
    RestTemplate restTemplate;

    /**
     * 使用方式一：Ribbon注解方式负载均衡使用： @LoadBalanced是实现负载均衡的  做了拦截 LoadBalancerInterceptor
     */
    // 默认RestTemplate 没有注入到容器里面,所以这里要装载到容器中，然后在使用
    @Bean
    @LoadBalanced // 被LoadBalancerAutoConfiguration扫描了
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @GetMapping("/user/{id}")
    public String findById(@PathVariable("id") int id) {
        //TODO
        // 调用订单的服务获得订单信息
        // HttpClient  RestTemplate  OkHttp   JDK HttpUrlConnection、
        System.out.println("@LoadBalanced");
        return restTemplate.getForObject("http://spring-cloud-order-service/orders",String.class);
    }

    //===================================================================================================================


    @Bean("restTemplate1")
    public RestTemplate rest() {
        return new RestTemplate();
    }

    @Qualifier("restTemplate1") // 这里指定注入bean为restTemplate1的bean
    @Autowired
    RestTemplate restTemplate1;

    /**
     * 使用方式二： Ribbon 接口负载均衡使用  只是做了筛选
     */
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test/{id}")
    public String findById1(@PathVariable("id") int id) {
        // 使用方式
        // choose方法是做一个负载均衡的计算，得到一个请求地址
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-order-service");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/orders");
        System.out.println("LoadBalancerClient");
        return restTemplate1.getForObject(url, String.class);
    }

}
