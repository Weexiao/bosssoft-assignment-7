package com.example.springcloudconsumerfeign.controller;

import com.example.springcloudconsumerfeign.service.UserFeignService;
import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.dto.UserRoleDTO;
import com.example.springcloudprovider8081.entity.po.UserPO;
import com.example.springcloudprovider8081.entity.vo.RoleVO;
import com.example.springcloudprovider8081.entity.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userConsumer")
@DefaultProperties(defaultFallback = "user_Global_Fallback")
public class UserController_Consumer {
    @Resource
    private UserFeignService userFeignService;

    @GetMapping("/user/listAll")
    @HystrixCommand
    public Result listAll(){
        return userFeignService.listAll();
    }

    @GetMapping("/user/list")
    @HystrixCommand
    public Result list(@SpringQueryMap UserVO userVO){
        return userFeignService.list(userVO);
    }

    @PostMapping("/user/add")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:user:add')")
    public Result add(@RequestBody UserPO userPO){
        return userFeignService.add(userPO);
    }

    @PutMapping("/user/update")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:user:edit')")
    public Result update(@RequestBody UserPO userPO){
        return userFeignService.update(userPO);
    }

    @DeleteMapping("/user/delete/{userId}")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:user:delete')")
    public Result delete(@PathVariable Long userId){
        return userFeignService.delete(userId);
    }

    @GetMapping("/user/getRoleListForAssign")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result getRoleListForAssign(@SpringQueryMap RoleVO roleVO){
        return userFeignService.getRoleListForAssign(roleVO);
    }

    @GetMapping("/user/getRoleListByUserId/{userId}")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result getRoleListByUserId(@PathVariable Long userId){
        return userFeignService.getRoleListByUserId(userId);
    }

    @PostMapping("/user/saveUserRole")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result saveUserRole(@RequestBody UserRoleDTO userRoleDTO){
        return userFeignService.saveUserRole(userRoleDTO);
    }

    @PostMapping("/user/register")
    public Result register(@RequestBody UserPO userPO){
        return userFeignService.register(userPO);
    }

    @PutMapping("/user/updatePassword")
    public Result updatePassword(@RequestBody UserPO userPO){
        return userFeignService.updatePassword(userPO);
    }

    public Result user_Global_FallbackMethod(){
        return Result.error().message("友情提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）");
    }
}
