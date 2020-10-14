package com.gupao.example.config;

import com.gupao.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity 的配置类
 *
 * @Author: mafenglei @Date: 2020/10/13 22:36
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    /**
     * 自定义认证管理器
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication()
                .withUser("zhang")// 登录的用户为zhang
                .password("{noop}111") // 不加密 密码为111
                .roles("USER");*/
        auth.userDetailsService(userService).passwordEncoder(encoder());
    }

    /**
     * 密码加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder encoder() {
       return new BCryptPasswordEncoder();
    }

    /**
     * 自定义过滤器链
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 调用父类中的方法 使用默认的过滤器链
        super.configure(http);
    }
}