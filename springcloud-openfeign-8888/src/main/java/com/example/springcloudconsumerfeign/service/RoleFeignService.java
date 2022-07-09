package com.example.springcloudconsumerfeign.service;

import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.dto.RolePermissionDTO;
import com.example.springcloudprovider8081.entity.po.RolePO;
import com.example.springcloudprovider8081.entity.vo.RoleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDER", contextId = "roleFeignService")
public interface RoleFeignService {
    @GetMapping("/role/list")
    public Result findRoleListByUserId(@SpringQueryMap RoleVO roleVO);

    @PostMapping("/role/add")
    public Result add(@RequestBody RolePO rolePO);

    @PutMapping("/role/update")
    public Result update(@RequestBody RolePO rolePO);

    @DeleteMapping("/role/delete/{id}")
    public Result delete(@PathVariable(value = "id") Long id);

    @GetMapping("/role/getAssignPermissionTree")
    public Result getAssignPermissionTree(@RequestParam("userId") Long userId, @RequestParam("roleId") Long roleId);

    @PostMapping("/role/saveRolePermission")
    public Result saveRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO);

    @GetMapping("/role/check/{roleId}")
    public Result check(@PathVariable(value = "roleId") Long roleId);
}
