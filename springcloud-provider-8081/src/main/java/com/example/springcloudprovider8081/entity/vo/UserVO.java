<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.UserPO;
import lombok.Data;

@Data
public class UserVO extends UserPO {

    private Long pageNo = 1L; // 当前页
    private Long pageSize = 10L; // 每页显示条数

}
=======
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.UserPO;
import lombok.Data;

@Data
public class UserVO extends UserPO {

    private Long pageNo = 1L; // 当前页
    private Long pageSize = 10L; // 每页显示条数

}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
