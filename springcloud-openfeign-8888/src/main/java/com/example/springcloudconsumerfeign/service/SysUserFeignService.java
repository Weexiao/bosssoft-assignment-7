package com.example.springcloudconsumerfeign.service;

import com.example.springcloudprovider8081.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDER", contextId = "sysUserFeignService")
public interface SysUserFeignService {
    @PostMapping("/sysUser/refreshToken")
    public Result refreshToken(HttpServletRequest request);

    @GetMapping("/sysUser/getInfo")
    public Result getInfo();

    @GetMapping("/sysUser/getMenuList")
    public Result getMenuList();

    @PostMapping("/sysUser/logout")
    public Result logout();
}
