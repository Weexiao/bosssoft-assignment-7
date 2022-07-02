<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用于给用户分配角色时保存选中的角色信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {

    private Long userId;
    private List<Long> roleIds;

}
=======
package com.example.springcloudprovider8081.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用于给用户分配角色时保存选中的角色信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {

    private Long userId;
    private List<Long> roleIds;

}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
