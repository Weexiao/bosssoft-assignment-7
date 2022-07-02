<<<<<<< HEAD
package com.example.springcloudeureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启 Eureka server,接受其他微服务的注册
public class SpringcloudEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka7001Application.class, args);
    }

=======
package com.example.springcloudeureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启 Eureka server,接受其他微服务的注册
public class SpringcloudEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka7001Application.class, args);
    }

>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
}