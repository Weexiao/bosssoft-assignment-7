package com.example.springcloudconsumerfeign.service;

import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.po.DepartmentPO;
import com.example.springcloudprovider8081.entity.vo.DepartmentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//添加为容器内的一个组件
@Component
// 服务提供者提供的服务名称，即 application.name
@FeignClient(value = "MICROSERVICECLOUDPROVIDER", contextId = "deptFeignService")
public interface DeptFeignService {

    // 对应服务提供者（8001、8002、8003）Controller 中定义的方法
    @GetMapping("/department/list")
    public Result findDepartmentList(@RequestParam(value = "departmentVO", required = false) DepartmentVO departmentVO);

    @GetMapping("/department/parent/list")
    public Result findParentDepartment();

    @PostMapping("/department/add")
    // @PreAuthorize("hasAuthority('sys:department:add')")
    public Result addDepartment(@RequestBody DepartmentPO departmentPO);

    @PutMapping("/department/update")
    // @PreAuthorize("hasAuthority('sys:department:edit')")
    public Result updateDepartment(@RequestBody DepartmentPO departmentPO);

    @GetMapping("/department/check/{id}")
    // @PreAuthorize("hasAuthority('sys:department:delete')")
    public Result hasChildOfDepartment(@PathVariable(value = "id") Long id);

    @DeleteMapping("/department/delete/{id}")
    // @PreAuthorize("hasAuthority('sys:department:delete')")
    public Result deleteDepartment(@PathVariable(value = "id") Long id);

}
