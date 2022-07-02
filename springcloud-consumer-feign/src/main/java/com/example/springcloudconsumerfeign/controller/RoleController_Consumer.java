package com.example.springcloudconsumerfeign.controller;

import com.example.springcloudconsumerfeign.service.RoleFeignService;
import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.dto.RolePermissionDTO;
import com.example.springcloudprovider8081.entity.po.RolePO;
import com.example.springcloudprovider8081.entity.vo.RoleVO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/roleConsumer")
@DefaultProperties(defaultFallback = "role_Global_FallbackMethod") //全局的服务降级方法
public class RoleController_Consumer {

    @Resource
    private RoleFeignService roleFeignService;

    @GetMapping("/role/list")
    @HystrixCommand
    public Result findRoleListByUserId(@RequestParam(value = "roleVO", required = false) RoleVO roleVO){
        return roleFeignService.findRoleListByUserId(roleVO);
    }

    @PostMapping("/role/add")
    @HystrixCommand
    public Result add(@RequestBody RolePO rolePO){
        return roleFeignService.add(rolePO);
    }

    @PutMapping("/role/update")
    @HystrixCommand
    public Result update(@RequestBody RolePO rolePO){
        return roleFeignService.update(rolePO);
    }

    @DeleteMapping("/role/delete/{id}")
    @HystrixCommand
    public Result delete(@PathVariable Long id){
        return roleFeignService.delete(id);
    }

    @GetMapping("/role/getAssignPermissionTree")
    @HystrixCommand
    public Result getAssignPermissionTree(@RequestParam("userId") Long userId, @RequestParam("roleId") Long roleId){
        return roleFeignService.getAssignPermissionTree(userId, roleId);
    }

    @PostMapping("/role/saveRolePermission")
    @HystrixCommand
    public Result saveRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO){
        return roleFeignService.saveRolePermission(rolePermissionDTO);
    }

    @GetMapping("/role/check/{roleId}")
    @HystrixCommand
    public Result check(@PathVariable Long roleId){
        return roleFeignService.check(roleId);
    }

    public Result role_Global_FallbackMethod(){
        return Result.error().message("友情提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）");
    }
}
