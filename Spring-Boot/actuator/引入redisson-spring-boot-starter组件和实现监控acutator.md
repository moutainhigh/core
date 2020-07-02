##Actuator(监控)
哎ke哎头
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/info
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
> https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints

## health健康检测

## Metrics
  检测系统运行的当前指标 jvm,访问你地址http://localhost:8080/actuator/metrics   （埋脆斯)
- JVM (垃圾收集器/内存/堆)
- 系统(运行时间、平均负载、处理器的信息)线程池信息
- tomcat会话信息
- Pheuthous / Grafana(图标展示)
## loggers

##info
- http://localhost:8080/actuator/logger/ROOT   修改日志级别   post请求  参数INFO

## Actuator有两种形态的监控
- http (web)
- jmx

## JMX (Java Management Extensions)
JMX全称是Java Management Extensions, Java管理扩展。它提供了对ava应用程序和IVM的监控和管理功能。通过JMX,我们可以监控
1.服务器中的各种资源的使用情况, CPU、内存
2.JVM内存的使用情况
3.JVM线程使用情况