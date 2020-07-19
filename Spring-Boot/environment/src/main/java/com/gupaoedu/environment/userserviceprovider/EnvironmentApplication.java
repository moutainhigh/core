package com.gupaoedu.environment.userserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@ComponentScan(basePackages = {"com.gupaoedu.environment.controller", "com.gupaoedu.environment.sourceloader"})
@SpringBootApplication
public class EnvironmentApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EnvironmentApplication.class, args);

        //        ConfigurableApplicationContext context=SpringApplication.run(UserServiceProviderApplication.class, args);
        SpringApplication springApplication = new SpringApplication(EnvironmentApplication.class);
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        springApplication.setDefaultProperties(map);
        springApplication.run(args);
    }

}
