<<<<<<< HEAD
package com.example.springcloudprovider8081.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springcloudprovider8081.entity.po.UserPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */
public interface UserMapper extends BaseMapper<UserPO> {

    /**
     * 删除用户角色关系
     * @param userId
     * @return
     */
    @Delete("delete from sys_user_role where user_id = #{userId}")
    int deleteUserRoleByUserId(Long userId);

    /**
     * 保存用户角色关系
     * @param userId
     * @param roleIds
     * @return
     */
    int saveUserRole(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

}
=======
package com.example.springcloudprovider8081.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springcloudprovider8081.entity.po.UserPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */
public interface UserMapper extends BaseMapper<UserPO> {

    /**
     * 删除用户角色关系
     * @param userId
     * @return
     */
    @Delete("delete from sys_user_role where user_id = #{userId}")
    int deleteUserRoleByUserId(Long userId);

    /**
     * 保存用户角色关系
     * @param userId
     * @param roleIds
     * @return
     */
    int saveUserRole(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
