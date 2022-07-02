<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.RolePO;
import lombok.Data;


@Data
public class RoleVO extends RolePO {
    private Long pageNo = 1L; // 当前页
    private Long pageSize = 10L; // 每页显示条数
    private Long userId; // 用户id
}
=======
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.RolePO;
import lombok.Data;


@Data
public class RoleVO extends RolePO {
    private Long pageNo = 1L; // 当前页
    private Long pageSize = 10L; // 每页显示条数
    private Long userId; // 用户id
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
