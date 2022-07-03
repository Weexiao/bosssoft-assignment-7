package com.example.springcloudgateway8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudGateway8080Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGateway8080Application.class, args);
    }

}
