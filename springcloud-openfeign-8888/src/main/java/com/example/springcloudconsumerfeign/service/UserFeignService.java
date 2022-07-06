package com.example.springcloudconsumerfeign.service;

import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.dto.UserRoleDTO;
import com.example.springcloudprovider8081.entity.po.UserPO;
import com.example.springcloudprovider8081.entity.vo.RoleVO;
import com.example.springcloudprovider8081.entity.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDER", contextId = "userFeignService")
public interface UserFeignService {
    @GetMapping("/user/listAll")
    public Result listAll();

    @GetMapping("/user/list")
    public Result list(@RequestParam(value = "userVO", required = false) UserVO userVO);

    @PostMapping("/user/add")
    // @PreAuthorize("hasAuthority('sys:user:add')")
    public Result add(@RequestBody UserPO userPO);

    @PutMapping("/user/update")
    // @PreAuthorize("hasAuthority('sys:user:edit')")
    public Result update(@RequestBody UserPO userPO);

    @DeleteMapping("/user/delete/{userId}")
    // @PreAuthorize("hasAuthority('sys:user:delete')")
    public Result delete(@PathVariable(value = "userId") Long userId);

    @GetMapping("/user/getRoleListForAssign")
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result getRoleListForAssign(@RequestParam(value = "roleVO", required = false) RoleVO roleVO);

    @GetMapping("/user/getRoleListByUserId/{userId}")
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result getRoleListByUserId(@PathVariable(value = "userId") Long userId);

    @PostMapping("/user/saveUserRole")
    // @PreAuthorize("hasAuthority('sys:user:assign')")
    public Result saveUserRole(@RequestBody UserRoleDTO userRoleDTO);

    @PostMapping("/user/register")
    public Result register(@RequestBody UserPO userPO);

    @PutMapping("/user/updatePassword")
    public Result updatePassword(@RequestBody UserPO userPO);

    @PostMapping("/user/login")
    public Result login(UserPO userPO);
}
