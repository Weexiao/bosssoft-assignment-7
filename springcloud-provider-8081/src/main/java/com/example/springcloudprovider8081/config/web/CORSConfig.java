<<<<<<< HEAD
package com.example.springcloudprovider8081.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("跨域配置成功");

        registry.addMapping(" /**")  //允许所有的访问请求(访问路径)
                .allowedMethods("*")            //允许所有的请求方法访问该跨域资源服务器
                .allowedOrigins("*")            //允许所有的请求域名访问我们的跨域资源
                .allowedHeaders("*");           //允许所有的请求header访问
    }
}

=======
package com.example.springcloudprovider8081.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("跨域配置成功");

        registry.addMapping(" /**")  //允许所有的访问请求(访问路径)
                .allowedMethods("*")            //允许所有的请求方法访问该跨域资源服务器
                .allowedOrigins("*")            //允许所有的请求域名访问我们的跨域资源
                .allowedHeaders("*");           //允许所有的请求header访问
    }
}

>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
