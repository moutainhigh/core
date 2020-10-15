package com.gupao.example.config;

import com.gupao.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;

import javax.sql.DataSource;

/**
 * SpringSecurity 的配置类
 *
 * @Author: mafenglei @Date: 2020/10/13 22:36
 */
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 表示支持spring表达式注解
//@EnableGlobalMethodSecurity(jsr250Enabled = true) // 示支持jsr250-api的注解
@EnableGlobalMethodSecurity(securedEnabled = true) // 这才是SpringSecurity提供的注解
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

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
                .antMatchers("/order/order1").hasRole("USER")
                .antMatchers("/order/order2", "/order/order3").hasRole("CREATE")
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
                .rememberMe() //开启remember-me功能
                .tokenRepository(persistentTokenRepository);
               /* .and()
                    .csrf()
                    .disable();  // 关闭跨域攻击*/
        // 单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
//        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
    }

    /**
     * 持久化token
     * Security中，默认是使用PersistentTokenRepository的子类InMemoryTokenRepositoryImpl，将token放在内存中
     * 如果使用JdbcTokenRepositoryImpl，会创建表persistent_logins，将token持久化到数据库
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 第一次创建表结构 执行后注销掉
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Bean
    public SessionInformationExpiredStrategy expiredSessionStrategy() {
        return new SimpleRedirectSessionInformationExpiredStrategy("/logout");
    }

}