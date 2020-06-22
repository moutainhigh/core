package com.gupaoedu.spring1xdemo;

/**
 * 统一约定接口  模块公用 这样才是分布式 如果不拆分出来 模块之间就没法公用，也就没法模块之间来回调用，也就没法实现rpc远程调用
 *
 * http://www.gupaoedu.com
 **/
public interface IOrderService {

    String queryOrderList();

    String orderById(String id);
}
