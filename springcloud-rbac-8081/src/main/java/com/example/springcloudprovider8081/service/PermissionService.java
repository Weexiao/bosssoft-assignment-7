
package com.example.springcloudprovider8081.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springcloudprovider8081.entity.po.PermissionPO;
import com.example.springcloudprovider8081.entity.vo.PermissionVO;
import com.example.springcloudprovider8081.entity.vo.RolePermissionVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */
public interface PermissionService extends IService<PermissionPO> {

    /**
     * 根据用户ID查询权限列表
     * @param userId
     * @return
     */
    List<PermissionPO> findPermissionListByUserId(Long userId);

    /**
     * 查询菜单列表
     * @param permissionVO
     * @return
     */
    List<PermissionPO> findPermissionList(PermissionVO permissionVO);

    /**
     * 查询上级菜单列表
     * @return
     */
    List<PermissionPO> findParentPermissionList();

    /**
     * 查询菜单是否存在子菜单
     * @param permissionId
     * @return
     */
    boolean hasChildrenOfPermission(Long permissionId);

    /**
     * 查询分配设备树列表
     * @param userId
     * @param roleId
     * @return
     */
    RolePermissionVO getAssignPermissionTree(Long userId, Long roleId);

    /**
     * 根据url查询权限
     * @param url
     * @return
     */
    PermissionPO getPermissionByUrl(String url);
}
