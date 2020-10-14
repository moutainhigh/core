package com.gupao.example.service.impl;

import com.gupao.example.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Titile: IntelliJ IDEA
 * @Description:
 * @Author: mafenglei @Date: 2020/10/13 22:45
 * @Version:1.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 自定义认证逻辑的方法，登录用户名为lisi，密码为222
     */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("UserServiceImpl: 自定义的认证逻辑实现");
        // 保存权限的集合
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        // 此处我们直接写在代码中，此处能实现那么数据库的验证自然能实现
        list.add(new SimpleGrantedAuthority("USER"));
        if (!"lisi".equals(s)) {
            return null;
        }
//        UserDetails user = new User("lisi", "{noop}222", list);
        UserDetails user = new User("lisi"
                ,"$2a$10$TxrezMczwVOhqolqeFy2buk7tB.c3wghMJOUaBL7qZqUNVi/90OIq" //明文就不需要{noop}了
                , true // 是否可用
                , false // 账号是否过期
                , true // 密码过期
                , true  // 账号被锁定
                ,list
        );
        return user;
    }
}
