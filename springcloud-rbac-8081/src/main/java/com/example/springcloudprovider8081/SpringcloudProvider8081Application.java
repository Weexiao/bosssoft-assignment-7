package com.example.springcloudprovider8081;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.springcloudprovider8081.dao")     // 加载Mapper接口
@ComponentScan(basePackages = "com.example.springcloudprovider8081.*") // 加载配置
@EnableEurekaClient // Spring cloud Eureka 客户端，自动将本服务注册到 Eureka Server 注册中心中
public class SpringcloudProvider8081Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8081Application.class, args);
    }

}
