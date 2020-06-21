package com.gupaoedu.example.impl;

import com.gupaoedu.example.IOrderService;
import com.gupaoedu.example.annotation.GpRemoteService;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
//使用这个注解之后，自动发布服务
@GpRemoteService
public class OrderServiceImpl implements IOrderService {

    @Override
    public String queryOrderList() {
        return "EXECUTE QUERYORDERLIST METHOD";
    }

    @Override
    public String orderById(String id) {
        return "EXECUTE ORDER_BY_ID METHOD";
    }
}
