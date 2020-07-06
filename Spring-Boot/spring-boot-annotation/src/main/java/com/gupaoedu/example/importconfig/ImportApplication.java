package com.gupaoedu.example.importconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Titile: IntelliJ IDEA
 * @Description:
 * @Author: mafenglei @Date: 2020/7/6 22:48
 * @Version:1.0
 */
@EnableGpRegistrara  // �����Լ�д��ע��
//@ComponentScan(basePackages = "com.gupaoedu")
@SpringBootApplication
public class ImportApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(ImportApplication.class, args);
        HelloService bean = cac.getBean(HelloService.class);
        System.out.println(bean.toString());
        bean.say();
    }

}
