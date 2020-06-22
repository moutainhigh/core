package com.gupaoedu.spring1xdemo.impl;

import com.gupaoedu.spring1xdemo.ITestService;
import com.gupaoedu.spring1xdemo.annotation.GpRemoteService;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@GpRemoteService
public class TestServiceImpl implements ITestService {
    @Override
    public String sayHello() {
        return "RETURN SAYHELLO";
    }
}
