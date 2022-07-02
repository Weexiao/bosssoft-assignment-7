package com.example.springcloudconsumerfeign.controller;

import com.example.springcloudconsumerfeign.service.DeptFeignService;
import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.po.DepartmentPO;
import com.example.springcloudprovider8081.entity.vo.DepartmentVO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/deptConsumer")
@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") //全局的服务降级方法
public class DepartmentController_Consumer {
    @Resource
    private DeptFeignService deptFeignService;

    @GetMapping("/department/list")
    @HystrixCommand
    public Result findDepartmentList(@RequestParam(value = "departmentVO", required = false) DepartmentVO departmentVO){
        return deptFeignService.findDepartmentList(departmentVO);
    }

    @GetMapping("/department/parent/list")
    @HystrixCommand
    public Result findParentDepartment(){
        return deptFeignService.findParentDepartment();
    }

    @PostMapping("/department/add")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:department:add')")
    public Result addDepartment(@RequestBody DepartmentPO departmentPO){
        return deptFeignService.addDepartment(departmentPO);
    }

    @PutMapping("/department/update")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:department:edit')")
    public Result updateDepartment(@RequestBody DepartmentPO departmentPO){
        return deptFeignService.updateDepartment(departmentPO);
    }

    @GetMapping("/department/check/{id}")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:department:delete')")
    public Result hasChildOfDepartment(@PathVariable Long id){
        return deptFeignService.hasChildOfDepartment(id);
    }

    @DeleteMapping("/department/delete/{id}")
    @HystrixCommand
    // @PreAuthorize("hasAuthority('sys:department:delete')")
    public Result deleteDepartment(@PathVariable Long id){
        return deptFeignService.deleteDepartment(id);
    }


    /**
     * 全局的 fallback 方法，
     * 回退方法必须和 hystrix 的执行方法在相同类中
     * @DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") 类上注解，请求方法上使用 @HystrixCommand 注解
     */
    public Result dept_Global_FallbackMethod() {
        return Result.error().message("友情提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）");
    }
}
