<<<<<<< HEAD
package com.example.springcloudprovider8081.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springcloudprovider8081.entity.po.PermissionPO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */
public interface PermissionMapper extends BaseMapper<PermissionPO> {

    /**
     * 根据用户ID查询权限列表
     * @param userId
     * @return
     */
    List<PermissionPO> findPermissionListByUserId(Long userId);

    /**
     * 根据角色ID查询权限列表
     * @param roleId
     * @return
     */
    List<PermissionPO> findPermissionListByRoleId(Long roleId);
}
=======
package com.example.springcloudprovider8081.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springcloudprovider8081.entity.po.PermissionPO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */
public interface PermissionMapper extends BaseMapper<PermissionPO> {

    /**
     * 根据用户ID查询权限列表
     * @param userId
     * @return
     */
    List<PermissionPO> findPermissionListByUserId(Long userId);

    /**
     * 根据角色ID查询权限列表
     * @param roleId
     * @return
     */
    List<PermissionPO> findPermissionListByRoleId(Long roleId);
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
