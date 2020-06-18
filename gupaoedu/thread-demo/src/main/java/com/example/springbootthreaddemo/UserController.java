package com.example.springbootthreaddemo;

import com.example.springbootthreaddemo.persistence.User;
import com.example.springbootthreaddemo.service.IUserService;
import com.example.springbootthreaddemo.service.SmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 风骚的Mic 老师
 * create-date: 2020/5/16-20:45
 */
@RestController
public class UserController {
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    private IUserService userService;

    @Autowired
    private SmsClient smsClient;

    @PostMapping("/user")
    public String addUser(User user) {
        long start = System.currentTimeMillis();
        userService.insert(user);
        long end = System.currentTimeMillis();
        return "SUCCESS:" + (end - start);
    }


    @PostMapping("/sms/user")
    public String register(User user) {
        long start = System.currentTimeMillis();
        userService.insert(user);
        //异步.  Future ->
        //MQ来代替
        // 如果请求数很大就会创建N个线程，线程太多，就会出现线程切换非常频繁，就会占用CPU资源，性能就会下降很厉害
        // 所以这里采用线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                smsClient.sendSms("16607691862");
            }
        });
        long end = System.currentTimeMillis();
        return "SUCCESS:" + (end - start);
    }
}
