package com.example.springcloudprovider8081.config.security;

import com.example.springcloudprovider8081.config.handler.AnonymousAuthenticationHandler;
import com.example.springcloudprovider8081.config.handler.CustomerAccessDeniedHandler;
import com.example.springcloudprovider8081.config.handler.LoginFailureHandler;
import com.example.springcloudprovider8081.config.handler.LoginSuccessHandler;
import com.example.springcloudprovider8081.filter.CheckTokenFilter;
import com.example.springcloudprovider8081.filter.CustomAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * 将各种设置贯穿起来，并整合
 */

@Slf4j
@Configuration
@EnableWebSecurity
// 开启权限注解控制
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private CustomerUserDetailsService userDetailsService;

    @Resource
    private LoginSuccessHandler loginSuccessHandler;

    @Resource
    private LoginFailureHandler loginFailureHandler;

    @Resource
    private AnonymousAuthenticationHandler anonymousAuthenticationHandler;

    @Resource
    private CustomerAccessDeniedHandler accessDeniedHandler;

    @Resource
    private CheckTokenFilter checkTokenFilter;

    /**
     * 注入加密处理类
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 处理登录认证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("处理登录认证");
        // 登录前先过滤
        http.addFilterBefore(checkTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 登录前进行配置
        http.formLogin()
                .loginProcessingUrl("/user/login")          // 表单登录请求的地址
                .successHandler(loginSuccessHandler)        // 登录成功处理器
                .failureHandler(loginFailureHandler)        // 登录失败处理器
                // 禁用csrf防御机制
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 不创建session
                .and()
                .authorizeRequests()                        // 设置需要拦截的请求
                .antMatchers(
                        "/user/login",
                        "/user/forgotpassword",
                        "/user/register").permitAll()
                .anyRequest().authenticated()               // 其他请求都需要认证
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationHandler)
                .accessDeniedHandler(accessDeniedHandler)
                .and().cors(); // 允许跨域访问
    }

    /**
     * 设置认证管理器
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("设置认证管理器");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

