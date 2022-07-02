<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenVO {
    // 过期时间
    private Long expireTime;
    // token
    private String token;
}
=======
package com.example.springcloudprovider8081.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenVO {
    // 过期时间
    private Long expireTime;
    // token
    private String token;
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
