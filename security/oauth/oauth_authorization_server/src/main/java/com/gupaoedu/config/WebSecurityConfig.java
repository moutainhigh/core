package com.gupaoedu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 让每一个人的职业生涯不留遗憾
 * SpringSecurity的配置文件
 *
 * @author 波波老师【咕泡学院】
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/gp/gp1").hasAnyAuthority("p1")
                //.antMatchers("/gp/gp2").hasAnyAuthority("p2")
                //.antMatchers("/login").permitAll()
                .anyRequest().authenticated() // 所有的请求都需要验证
                .and()
                    .formLogin() // 默认的表单登录
                .and()
                    .csrf().disable();// 关闭csrf跨域保护
    }

    /**
     * 配置账号
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhang")
                .password(bCryptPasswordEncoder.encode("123"))
                .authorities("ROOT");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     *
     * 将AuthenticationManager 注入IoC容器
     */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
