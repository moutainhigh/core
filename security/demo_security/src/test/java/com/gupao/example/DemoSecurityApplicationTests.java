package com.gupao.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoSecurityApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("====");
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String password = "123456";
        System.out.println(bCrypt.encode(password));
        System.out.println(bCrypt.encode(password));
        System.out.println(bCrypt.encode(password));
        System.out.println(bCrypt.encode(password));
    }

}
