##Actuator(���)
��ke��ͷ
- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/info
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
> https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints

## health�������

## Metrics
  ���ϵͳ���еĵ�ǰָ�� jvm,�������ַhttp://localhost:8080/actuator/metrics   �����˹)
- JVM (�����ռ���/�ڴ�/��)
- ϵͳ(����ʱ�䡢ƽ�����ء�����������Ϣ)�̳߳���Ϣ
- tomcat�Ự��Ϣ
- Pheuthous / Grafana(ͼ��չʾ)
## loggers

##info
- http://localhost:8080/actuator/logger/ROOT   �޸���־����   post����  ����INFO

## Actuator��������̬�ļ��
- http (web)
- jmx

## JMX (Java Management Extensions)
JMXȫ����Java Management Extensions, Java������չ�����ṩ�˶�avaӦ�ó����IVM�ļ�غ͹����ܡ�ͨ��JMX,���ǿ��Լ��
1.�������еĸ�����Դ��ʹ�����, CPU���ڴ�
2.JVM�ڴ��ʹ�����
3.JVM�߳�ʹ�����