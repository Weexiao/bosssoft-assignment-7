package com.example.springcloudprovider8081.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.dto.RolePermissionDTO;
import com.example.springcloudprovider8081.entity.po.RolePO;
import com.example.springcloudprovider8081.entity.vo.RolePermissionVO;
import com.example.springcloudprovider8081.entity.vo.RoleVO;
import com.example.springcloudprovider8081.service.PermissionService;
import com.example.springcloudprovider8081.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    /**
     * 分页查询角色列表
     * @param roleVO
     * @return
     */
    @GetMapping("/list")
    public Result findRoleListByUserId(RoleVO roleVO) {
        log.info("分页查询角色列表");
        if (roleVO == null) {
            roleVO = new RoleVO();
        }
        // 创建分页对象
        IPage<RolePO> page = new Page<>(roleVO.getPageNo(), roleVO.getPageSize());
        // 调用分页查询方法
        roleService.findRoleListByUserId(page, roleVO);
        // 返回结果
        return Result.ok(page);
    }

    /**
     * 添加角色
     * @param rolePO
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public Result add(@RequestBody RolePO rolePO) {
        log.info("添加角色");
        if (roleService.save(rolePO)) {
            return Result.ok().message("角色添加成功");
        }
        return Result.error().message("角色添加失败");
    }

    /**
     * 修改角色
     * @param rolePO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('sys:role:edit')")
    public Result update(@RequestBody RolePO rolePO) {
        log.info("修改角色");
        if (roleService.updateById(rolePO)) {
            return Result.ok().message("角色修改成功");
        }
        return Result.error().message("角色修改失败");
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public Result delete(@PathVariable Long id) {
        log.info("删除角色");
        if (roleService.deleteRoleById(id)) {
            return Result.ok().message("角色删除成功");
        }
        return Result.error().message("角色删除失败");
    }

    /**
     * 分配权限-查询权限树数据
     * @param userId
     * @param roleId
     * @return
     */
    @GetMapping("/getAssignPermissionTree")
    public Result getAssignPermissionTree(Long userId, Long roleId) {
        log.info("分配权限-查询权限树数据");
        RolePermissionVO rolePermissionVO = permissionService.getAssignPermissionTree(userId, roleId);
        return Result.ok(rolePermissionVO);
    }

    /**
     * 分配权限-保存权限
     * @param rolePermissionDTO
     * @return
     */
    @PostMapping("/saveRolePermission")
    @PreAuthorize("hasAuthority('sys:role:edit')")
    public Result saveRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO) {
        log.info("分配权限-保存权限");
        if (roleService.saveRolePermission(rolePermissionDTO.getRoleId(), rolePermissionDTO.getPermissionIds())) {
            return Result.ok().message("权限分配成功");
        }
        return Result.error().message("权限分配失败");
    }

    /**
     * 检查该角色是否被分配
     * @param roleId
     * @return
     */
    @GetMapping("/check/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public Result check(@PathVariable Long roleId) {
        log.info("检查该角色是否被分配");
        if (roleService.getRoleCount(roleId)) {
            return Result.exist().message("该角色已被分配，不能删除");
        }
        return Result.ok().message("该角色未被分配，可以删除");
    }

}

