package com.example.springcloudconsumerfeign.controller;

import com.example.springcloudconsumerfeign.service.PermissionFeignService;
import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.po.PermissionPO;
import com.example.springcloudprovider8081.entity.vo.PermissionVO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/permissionConsumer")
@DefaultProperties(defaultFallback = "permission_Global_FallbackMethod") //全局的服务降级方法
public class PermissionController_Consumer {

    @Resource
    private PermissionFeignService permissionFeignService;

    @GetMapping("/permission/list")
    @HystrixCommand
    public Result getMenuList(@RequestParam(value = "permissionVO", required = false) PermissionVO permissionVO){
        return permissionFeignService.getMenuList(permissionVO);
    }

    @GetMapping("/permission/parent/list")
    @HystrixCommand
    public Result getParentList(){
        return permissionFeignService.getParentList();
    }

    @GetMapping("/permission/{id}")
    @HystrixCommand
    public Result getMenuById(@PathVariable Long id){
        return permissionFeignService.getMenuById(id);
    }

    @PostMapping("/permission/add")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:menu:add')")
    public Result add(@RequestBody PermissionPO permissionPO){
        return permissionFeignService.add(permissionPO);
    }

    @PutMapping("/permission/update")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:menu:edit')")
    public Result update(@RequestBody PermissionPO permissionPO){
        return permissionFeignService.update(permissionPO);
    }

    @DeleteMapping("/permission/delete/{id}")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result delete(@PathVariable Long id){
        return permissionFeignService.delete(id);
    }

    @GetMapping("/permission/check/{id}")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result check(@PathVariable Long id){
        return permissionFeignService.check(id);
    }

    /**
     * 全局的 fallback 方法，
     * 回退方法必须和 hystrix 的执行方法在相同类中
     * @DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") 类上注解，请求方法上使用 @HystrixCommand 注解
     */
    public Result permission_Global_FallbackMethod() {
        return Result.error().message("友情提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）");
    }
}
