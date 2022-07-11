package com.example.springcloudprovider8081.controller;


import com.example.springcloudprovider8081.common.Result;
import com.example.springcloudprovider8081.entity.po.DepartmentPO;
import com.example.springcloudprovider8081.entity.vo.DepartmentVO;
import com.example.springcloudprovider8081.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */

@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 获取部门列表
     * @param departmentVO
     * @return
     */
    @GetMapping("/list")
    public Result findDepartmentList(DepartmentVO departmentVO) {
        log.info("获取部门列表");
        System.out.println(departmentVO);
        if (departmentVO == null) {
            departmentVO = new DepartmentVO();
        }
        return Result.ok(departmentService.findDepartmentList(departmentVO));
    }

    /**
     * 获取上级部门列表
     * @return
     */
    @GetMapping("/parent/list")
    public Result findParentDepartment() {
        log.info("获取上级部门列表");
        return Result.ok(departmentService.findParentDepartment());
    }

    /**
     * 添加部门
     * @param departmentPO
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:department:add')")
    public Result addDepartment(@RequestBody DepartmentPO departmentPO) {
        log.info("添加部门");
        if (departmentService.save(departmentPO)) {
            return Result.ok().message("部门添加成功");
        }else {
            return Result.error().message("部门添加失败");
        }
    }

    /**
     * 修改部门
     * @param departmentPO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('sys:department:edit')")
    public Result updateDepartment(@RequestBody DepartmentPO departmentPO) {
        log.info("修改部门");
        if (departmentService.updateById(departmentPO)) {
            return Result.ok().message("部门修改成功");
        }else {
            return Result.error().message("部门修改失败");
        }
    }

    /**
     * 查询某个部门下是否有子部门
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    @PreAuthorize("hasAuthority('sys:department:delete')")
    public Result hasChildOfDepartment(@PathVariable Long id) {
        log.info("查询某个部门下是否有子部门");
        // 查询部门下是否有子部门
        if (departmentService.hasChildOfDepartment(id)) {
            return Result.exist().message("该部门下有子部门, 无法删除");
        }
        // 查询部门下是否有用户
        if (departmentService.hasUserOfDepartment(id)) {
            return Result.exist().message("该部门下有用户, 无法删除");
        }
        return Result.ok().message("该部门下无子部门或用户, 可以删除");
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('sys:department:delete')")
    public Result deleteDepartment(@PathVariable Long id) {
        log.info("删除部门");
        if (departmentService.removeById(id)) {
            return Result.ok().message("部门删除成功");
        }else {
            return Result.error().message("部门删除失败");
        }
    }
}

