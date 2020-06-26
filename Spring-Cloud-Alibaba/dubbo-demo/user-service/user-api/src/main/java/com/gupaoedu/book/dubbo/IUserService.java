package com.gupaoedu.book.dubbo;

/**
 * 服务对外提供的接口 多个模块调用  这么模块会被部署到Maven远程私服上，便于服务调用者对接口的实现
 * 统一约定接口  模块公用 这样才是分布式 如果不拆分出来 模块之间就没法公用，也就没法模块之间来回调用，也就没法实现rpc远程调用
 * create-date: 2020/1/6-11:38
 */
public interface IUserService {
    String getNameById(String uid);
}

