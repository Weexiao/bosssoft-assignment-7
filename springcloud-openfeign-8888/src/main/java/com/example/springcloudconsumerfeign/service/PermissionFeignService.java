package com.example.springcloudconsumerfeign.service;

import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.po.PermissionPO;
import com.example.springcloudprovider8081.entity.vo.PermissionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDER", contextId = "permissionFeignService")
public interface PermissionFeignService {
    @GetMapping("/permission/list")
    public Result getMenuList(@SpringQueryMap PermissionVO permissionVO);

    @GetMapping("/permission/parent/list")
    public Result getParentList();

    @GetMapping("/permission/{id}")
    public Result getMenuById(@PathVariable(value = "id") Long id);

    @PostMapping("/permission/add")
    // @PreAuthorize("hasAuthority('sys:menu:add')")
    public Result add(@RequestBody PermissionPO permissionPO);

    @PutMapping("/permission/update")
    // @PreAuthorize("hasAuthority('sys:menu:edit')")
    public Result update(@RequestBody PermissionPO permissionPO);

    @DeleteMapping("/permission/delete/{id}")
    // @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result delete(@PathVariable(value = "id") Long id);

    @GetMapping("/permission/check/{id}")
    // @PreAuthorize("hasAuthority('sys:menu:delete')")
    public Result check(@PathVariable(value = "id") Long id);
}
