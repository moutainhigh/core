FROM openjdk:8
#
MAINTAINER  mic@gupaoedu.com
# 设置标签 版本
LABEL name="gper-mall-eureka-server" version="1.0" author="Mic"

# 指定工作目录，不存在则会创建
WORKDIR /gper/base

# 发布端口
EXPOSE 9090

# 从物理机上拷贝到容器中
ADD ./spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar ./gper-mall-eureka-server.jar

ENTRYPOINT ["java", "-jar", "gper-mall-eureka-server.jar"]

#CMD ["--spring.profile.active=test"]