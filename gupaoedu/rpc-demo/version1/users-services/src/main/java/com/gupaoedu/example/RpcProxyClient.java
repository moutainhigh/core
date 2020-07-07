package com.gupaoedu.example;

import java.lang.reflect.Proxy;

/**
 * 客户端代理
 * http://www.gupaoedu.com
 **/
public class RpcProxyClient {

    /**
     * @param interfaceCls 动态调用的目标接口
     */
    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port) {
        // 处理类为 RemoteInvocationHandler
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
