<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用于给角色分配权限时保存选中的权限数据
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePermissionDTO {
    private Long roleId; // 角色ID
    private List<Long> permissionIds; // 权限菜单ID列表
}
=======
package com.example.springcloudprovider8081.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用于给角色分配权限时保存选中的权限数据
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolePermissionDTO {
    private Long roleId; // 角色ID
    private List<Long> permissionIds; // 权限菜单ID列表
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
