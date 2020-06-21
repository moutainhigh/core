package com.gupaoedu.example.impl;

import com.gupaoedu.example.ITestService;
import com.gupaoedu.example.annotation.GpRemoteService;

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
