<<<<<<< HEAD
package com.example.springcloudprovider8081.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResult {
    // 用户编号
    private Long userId;
    // 状态码
    private int status;
    // token令牌
    private String token;
    // token过期时间
    private Long expireTime;
}
=======
package com.example.springcloudprovider8081.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResult {
    // 用户编号
    private Long userId;
    // 状态码
    private int status;
    // token令牌
    private String token;
    // token过期时间
    private Long expireTime;
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
