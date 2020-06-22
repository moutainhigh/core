package com.gupaoedu.spring1xdemo.merdiator;

import com.gupaoedu.spring1xdemo.BeanMethod;
import com.gupaoedu.spring1xdemo.RpcRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 路由，处理对应的请求
 **/
public class Mediator {

    //用来存储发布的服务的实例(服务调用的路由)
    public static Map<String , BeanMethod> map=new ConcurrentHashMap<>();

    private volatile static Mediator instance;

    private Mediator(){};

    public static Mediator getInstance(){
        if(instance==null){
            synchronized (Mediator.class){
                if(instance==null){
                    instance=new Mediator();
                }
            }
        }
        return instance;
    }

    /**
     * 根据url找到 对应的处理调用
     */
    public Object processor(RpcRequest request){
        String key=request.getClassName()+"."+request.getMethodName(); //拼接key
        BeanMethod beanMethod=map.get(key);

        if(beanMethod==null){
            return null;
        }

        // 要调用的目标类
        Object bean=beanMethod.getBean();
        // 反射调用的方法
        Method method=beanMethod.getMethod();
        System.out.println("调用的服务端目标类：" + bean + ", 调用的方法：" + method.getName() + ", 参数：" + request.getArgs());
        printArgs(request.getArgs());

        try {
            // 反射调用  参数：调用的类 参数
            return method.invoke(bean,request.getArgs());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printArgs(Object[] args) {
        if(Objects.nonNull(args)){
            Arrays.asList(args).forEach((one) -> { System.out.println(one);});
        }
    }

}
