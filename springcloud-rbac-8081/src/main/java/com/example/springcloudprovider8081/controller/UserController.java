package com.example.springcloudprovider8081.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.dto.UserRoleDTO;
import com.example.springcloudprovider8081.entity.po.RolePO;
import com.example.springcloudprovider8081.entity.po.UserPO;
import com.example.springcloudprovider8081.entity.vo.RoleVO;
import com.example.springcloudprovider8081.entity.vo.UserVO;
import com.example.springcloudprovider8081.service.RoleService;
import com.example.springcloudprovider8081.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll() {
        log.info("获取用户列表");
        return Result.ok(userService.list());
    }

    /**
     * 查询用户列表
     * @param userVO
     * @return
     */
    @GetMapping("/list")
    public Result list(@RequestParam(value = "userVO", required = false) UserVO userVO) {
        log.info("查询用户列表");

        if (userVO == null) {
            userVO = new UserVO();
        }

        // 创建分页信息
        IPage<UserPO> page = new Page<>(userVO.getPageNo(), userVO.getPageSize());
        userService.findUserListByPage(page, userVO);
        return Result.ok(page);
    }

    /**
     * 添加用户
     * @param userPO
     * @return
     */
    @PostMapping("/add")
    // @PreAuthorize("hasAuthority('sys:user:add')")
    public Result add(@RequestBody UserPO userPO) {
        log.info("添加用户");

        // 查询用户
        UserPO item = userService.getUserByUsername(userPO.getUsername());
        // 判断用户是否存在
        if (item != null) {
            return Result.error().message("用户已存在，请重新输入");
        }
        // 密码加密
        userPO.setPassword(passwordEncoder.encode(userPO.getPassword()));
        // 调用保存用户信息的方法
        if (userService.save(userPO)) {
            return Result.ok().message("用户添加成功");
        }
        return Result.error().message("用户添加失败");
    }

    /**
     * 修改用户
     * @param userPO
     * @return
     */
    @PutMapping("/update")
    // @PreAuthorize("hasAuthority('sys:user:edit')")
    public Result update(@RequestBody UserPO userPO) {
        log.info("修改用户");

        // 查询用户
        UserPO item = userService.getUserByUsername(userPO.getUsername());
        // 判断用户是否存在
        if (item != null && !item.getId().equals(userPO.getId())) {
            return Result.error().message("登录名称已被占用");
        }
        // 调用修改用户信息的方法
        if (userService.updateById(userPO)) {
            return Result.ok().message("用户修改成功");
        }
        return Result.error().message("用户修改失败");
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    // @PreAuthorize("hasAuthority('sys:user:delete')")
    public Result delete(@PathVariable Long userId) {
        log.info("删除用户");

        // 调用删除用户信息的方法
        if (userService.deleteUserByUserId(userId)) {
            return Result.ok().message("用户删除成功");
        }
        return Result.error().message("用户删除失败");
    }

    /**
     * 获取分配角色列表
     * @param roleVO
     * @return
     */
    @GetMapping("/getRoleListForAssign")
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result getRoleListForAssign(@RequestParam(value = "roleVO", required = false) RoleVO roleVO) {
        log.info("获取分配角色列表");

        if (roleVO == null) {
            roleVO = new RoleVO();
        }

        // 创建分页对象
        IPage<RolePO> page = new Page<>(roleVO.getPageNo(), roleVO.getPageSize());
        // 调用获取分配角色列表的方法
        roleService.findRoleListByUserId(page, roleVO);
        return Result.ok(page);
    }

    /**
     * 根据用户ID查询该用户拥有的角色列表
     * @param userId
     * @return
     */
    @GetMapping("/getRoleListByUserId/{userId}")
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result getRoleListByUserId(@PathVariable Long userId) {
        log.info("根据用户ID查询该用户拥有的角色列表");

        // 调用获取该用户拥有的角色列表的方法
        return Result.ok(roleService.getRoleIdsByUserId(userId));
    }

    /**
     * 分配角色
     * @param userRoleDTO
     * @return
     */
    @PostMapping("/saveUserRole")
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result saveUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        log.info("分配角色");

        // 调用分配角色的方法
        if (userService.saveUserRole(userRoleDTO.getUserId(), userRoleDTO.getRoleIds())) {
            return Result.ok().message("分配角色成功");
        }
        return Result.error().message("分配角色失败");
    }

    /**
     * 用户注册
     * @param userPO
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody UserPO userPO) {
        log.info("用户注册");

        // 查询用户
        UserPO item = userService.getUserByUsername(userPO.getUsername());
        // 判断用户是否存在
        if (item != null) {
            return Result.error().message("用户已存在，请重新输入");
        }
        // 密码加密
        userPO.setPassword(passwordEncoder.encode(userPO.getPassword()));
        // 调用保存用户信息的方法
        if (userService.save(userPO)) {
            return Result.ok().message("用户注册成功");
        }
        return Result.error().message("用户注册失败");
    }

    /**
     * 修改密码
     * @param userPO
     * @return
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody UserPO userPO) {
        log.info("修改密码");

        userPO.setPassword(passwordEncoder.encode(userPO.getPassword()));
        // 调用修改密码的方法
        if (userService.updatePassword(userPO)) {
            return Result.ok().message("密码修改成功");
        }
        return Result.error().message("密码修改失败");
    }
}

