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
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 自定义认证管理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication()
                .withUser("zhang")// 登录的用户为zhang
                .password("{noop}111") // 不加密 密码为111
                .roles("USER");*/
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * 密码加密
     *
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
//        super.configure(http);

        http.authorizeRequests()
                .antMatchers("/login", "/failure").permitAll() // 放过 login和loign请求
                .anyRequest().authenticated() //  剩下的所有的地址都是需要在认证状态下才可以访问
                .and()
                    .formLogin() // 设置自定义登录页面认证表单
                    .loginPage("/login") // 自定义的登录界面的请求地址
                    .loginProcessingUrl("/login.do")  // 处理登录表单提交的请求，这里是表单提交中的地址
                    // 认证成功的跳转页面 默认是get方式提交 自定义的成功页面后会post方式提要
                    // 在Controller中处理的时候要注意
                    .successForwardUrl("/home")
                    .failureUrl("/failure") // 失败的页面
                    .permitAll()
                .and()
                    .logout()   // 设置自定义退出
                    .logoutUrl("/logout")  // 退出的请求地址
                    .invalidateHttpSession(true) // 注销会话
                    .logoutSuccessUrl("/login") // 注销成功后的跳转页面
                    .permitAll()
                .and()
                    .csrf()
                    .disable();  // 关闭跨域攻击
    }
}