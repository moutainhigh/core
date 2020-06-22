package com.gupaoedu.spring1xdemo.services.impl;

import com.gupaoedu.spring1xdemo.dao.entity.User;
import com.gupaoedu.spring1xdemo.dao.mappers.UserMapper;
import com.gupaoedu.spring1xdemo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserMapper userMapper;  //代理对象

    @Override
    public int insert(User user) {
        //TODO 业务逻辑
        return userMapper.insert(user);
    }
}
