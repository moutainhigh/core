package com.gupaoedu.spring1xdemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 请求处理器  异步处理  处理的是客户端的请求  每一个请求开启一个线程去处理
 * http://www.gupaoedu.com
 **/
public class ProcessorHandler implements Runnable {

    // 监听的客户端的连接
    private Socket socket;
    // 监听的类（就会调用订单服务接口实现者的代码）
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            //反序列化 得到请求的数据
            inputStream = new ObjectInputStream(socket.getInputStream());//?
            RpcRequest request = (RpcRequest) inputStream.readObject();

            // 反射调用订单服务的代码
            Object rs = invoke(request);
            System.out.println("调用服务端的代码执行结果：" + rs);

            // 序列化 数据写出去
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rs);
            outputStream.flush(); // 数据写出去
            System.out.println("代码执行结束，服务端回应客户端完成。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //TODO 关闭流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反射调用订单服务端的代码 返回服务端端代码的执行结果
     */
    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //通过反射进行服务的调用 先得到反射要调用的类
        Class clazz = Class.forName(request.getClassName());
        //找到目标方法  参数： 方法名 方法的参数类型
        Method method = clazz.getMethod(request.getMethodName(), request.getTypes());

        System.out.println("调用的服务端目标类：" + clazz + ", 调用的方法：" + request.getMethodName() + ", 参数：" + request.getArgs());
        printArgs(request.getArgs());

        // 调用服务端  参数：调用的类 参数
        // 想等于我拿着这个方法到目标类里面去掉用这个方法，目标类里面有这个方法就会调用到，其它目标类有这个方法同样也能调用到
        return method.invoke(service, request.getArgs());
    }

    public void printArgs(Object[] args) {
        if(Objects.nonNull(args)){
            Arrays.asList(args).forEach((one) -> { System.out.println(one);});
        }
    }

}
