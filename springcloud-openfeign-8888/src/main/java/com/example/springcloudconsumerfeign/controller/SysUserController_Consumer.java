package com.example.springcloudconsumerfeign.controller;

import com.example.springcloudconsumerfeign.service.SysUserFeignService;
import com.example.springcloudprovider8081.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sysUserConsumer")
public class SysUserController_Consumer {
    @Resource
    private SysUserFeignService sysUserFeignService;

    @PostMapping("/sysUser/refreshToken")
    public Result refreshToken(HttpServletRequest request){
        return sysUserFeignService.refreshToken(request);
    }

    @GetMapping("/sysUser/getInfo")
    public Result getInfo(){
        return sysUserFeignService.getInfo();
    }

    @GetMapping("/sysUser/getMenuList")
    public Result getMenuList(){
        return sysUserFeignService.getMenuList();
    }

    @PostMapping("/sysUser/logout")
    public Result logout(){
        return sysUserFeignService.logout();
    }
}
