package com.gupaoedu.example.rcp;

import com.gupaoedu.example.RpcRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的处理类：使用JDK内置的动态代理 实现InvocationHandler
 **/
@Component
public class RemoteInvocationHandler implements InvocationHandler{

    @Value("${gp.host}")
    private String host;
    @Value("${gp.port}")
    private int port;

    public RemoteInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //先建立远程连接
        RpcNetTransport rpcNetTransport=new RpcNetTransport(host,port);
        //传递数据了？
        // 调用哪个接口、 哪个方法、方法的参数？
        RpcRequest request=new RpcRequest();
        request.setArgs(args);
        request.setClassName(method.getDeclaringClass().getName());
        request.setTypes(method.getParameterTypes()); //参数的类型
        request.setMethodName(method.getName());

        return rpcNetTransport.send(request);
    }
}
