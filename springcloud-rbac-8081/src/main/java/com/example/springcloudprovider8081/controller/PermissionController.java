package com.example.springcloudprovider8081.controller;


import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.po.PermissionPO;
import com.example.springcloudprovider8081.entity.vo.PermissionVO;
import com.example.springcloudprovider8081.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * 查询菜单列表
     * @param permissionVO
     * @return
     */
    @GetMapping("/list")
    public Result getMenuList(PermissionVO permissionVO){
        log.info("查询菜单列表");
        if (permissionVO == null) {
            permissionVO = new PermissionVO();
        }
        // 查询菜单列表
        List<PermissionPO> list = permissionService.findPermissionList(permissionVO);
        // 返回数据
        return Result.ok(list);
    }

    /**
     * 查询上级菜单列表
     * @return
     */
    @GetMapping("/parent/list")
    public Result getParentList(){
        log.info("查询上级菜单列表");
        // 查询上级菜单列表
        List<PermissionPO> list = permissionService.findParentPermissionList();
        // 返回数据
        return Result.ok(list);
    }

    /**
     * 根据id查询菜单信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getMenuById(@PathVariable Long id){
        log.info("根据id查询菜单信息");
        return Result.ok(permissionService.getById(id));
    }

    /**
     * 添加菜单
     * @param permissionPO
     * @return
     */
    @PostMapping("/add")
    // @PreAuthorize("hasAuthority('sys:menu:add')")
    public Result add(@RequestBody PermissionPO permissionPO){
        log.info("添加菜单");
        if (permissionService.save(permissionPO)){
            return Result.ok().message("菜单添加成功");
        }
        return Result.error().message("菜单添加失败");
    }

    /**
     * 修改菜单
     * @param permissionPO
     * @return
     */
    @PutMapping("/update")
    // @PreAuthorize("hasAuthority('sys:menu:edit')")
    public Result update(@RequestBody PermissionPO permissionPO){
        log.info("修改菜单");
        if (permissionService.updateById(permissionPO)){
            return Result.ok().message("菜单修改成功");
        }
        return Result.error().message("菜单修改失败");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    // @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result delete(@PathVariable Long id){
        log.info("删除菜单");
        if (permissionService.removeById(id)){
            return Result.ok().message("菜单删除成功");
        }
        return Result.error().message("菜单删除失败");
    }

    /**
     * 检查菜单下是否有子菜单
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    // @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result check(@PathVariable Long id){
        log.info("检查菜单下是否有子菜单");
        if (permissionService.hasChildrenOfPermission(id)){
            return Result.exist().message("该菜单下有子菜单，无法删除");
        }
        return Result.ok().message("该菜单下无子菜单，可以删除");
    }
}

