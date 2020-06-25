
# 用户服务
SpringBoot项目
- SpringBoot
- 线程池
- 异步
- 反射
- Socket
- 动态代理 Proxy.newProxyInstance    InvocationHandler
- 声明注解
- 序列化 反序列化

## 补充
```
BeanPostProcessor的作用：  Spring IoC容器初始化受管Bean之前、属性设置之后对该Bean先做一些预处理和后处理
```

http://localhost:8080/test

------

#  订单服务
Spring项目
- 线程池
- 反射
- 异步
- ServerSocket
- 单例
- 声明注解
- 序列化 反序列化

```
ApplicationListener作用：当容器初始化完成之后，需要处理一些操作
 * 首先，需要实现ApplicationListener接口并实现onApplicationEvent方法。把需要处理的操作放在onApplicationEvent中进行处理：
```