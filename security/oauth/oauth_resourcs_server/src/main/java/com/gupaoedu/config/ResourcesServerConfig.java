package com.gupaoedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * 资源配置文件
 */
@Configuration
@EnableResourceServer  // 表示是资源服务，自动增加了一个类型为OAuth2ClientAuthenticationProcessingFilter的过滤器
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {
    // 访问资源的编号
    public static final String RESOURCE_ID = "res1";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID) // 资源编号，表示接受访问的资源的ID
                .tokenServices(tokenServices()) // 验证token信息的服务
                .stateless(true); // 无状态
    }

    /**
     * 远程验证Token信息的服务
     *
     * @return
     */
    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices services = new RemoteTokenServices();
        // 去 Token的授权服务检查token是否合法，源码是规定的请求地址
        services.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        services.setClientId("c1"); //允许c1客户端
        services.setClientSecret("secret");
        return services;
    }

    /**
     * 资源服务的权限
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .anyRequest().permitAll() //其它的请求都放过
                .and().csrf().disable()
                // 设置Session为无状态服务 提升效率
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
