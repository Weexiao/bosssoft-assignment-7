
package com.example.springcloudprovider8081.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springcloudprovider8081.dao.DepartmentMapper;
import com.example.springcloudprovider8081.dao.UserMapper;
import com.example.springcloudprovider8081.entity.po.DepartmentPO;
import com.example.springcloudprovider8081.entity.po.UserPO;
import com.example.springcloudprovider8081.entity.vo.DepartmentVO;
import com.example.springcloudprovider8081.service.DepartmentService;
import com.example.springcloudprovider8081.utils.DepartmentTreeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuhu
 * @since 2022-06-20
 */
@Service
@Transactional
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentPO> implements DepartmentService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询部门列表
     *
     * @param departmentVO
     * @return
     */
    @Override
    public List<DepartmentPO> findDepartmentList(DepartmentVO departmentVO) {
        // 创建条件查询构造器对象
        QueryWrapper<DepartmentPO> queryWrapper = new QueryWrapper<DepartmentPO>();
        // 部门名称
        queryWrapper.like(!ObjectUtils.isEmpty(departmentVO.getDepartmentName()),
                "department_name",
                departmentVO.getDepartmentName()
        );
        // 排序
        queryWrapper.orderByAsc("order_num");
        // 查询部门列表
        List<DepartmentPO> list = baseMapper.selectList(queryWrapper);
        // 生成部门树，只能生成顶级部门的树
        return DepartmentTreeUtils.makeDepartmentTree(list, 0L);
    }

    /**
     * 查询上级部门列表
     *
     * @return
     */
    @Override
    public List<DepartmentPO> findParentDepartment() {
        // 创建条件查询构造器对象
        QueryWrapper<DepartmentPO> queryWrapper = new QueryWrapper<DepartmentPO>();
        // 排序
        queryWrapper.orderByAsc("order_num");
        // 查询上级部门列表
        List<DepartmentPO> list = baseMapper.selectList(queryWrapper);

        // 创建部门对象
        DepartmentPO departmentPO = new DepartmentPO();
        departmentPO.setId(0L);
        departmentPO.setDepartmentName("顶级部门");
        departmentPO.setPid(-1L);
        list.add(departmentPO);

        // 生成部门树
        return DepartmentTreeUtils.makeDepartmentTree(list, -1L);
    }

    /**
     * 判断部门下是否有子部门
     *
     * @param id
     * @return
     */
    @Override
    public boolean hasChildOfDepartment(Long id) {
        // 创建条件查询构造器对象
        QueryWrapper<DepartmentPO> queryWrapper = new QueryWrapper<DepartmentPO>();
        queryWrapper.eq("pid", id);
        // 如果数量大于0，则表示存在
        return baseMapper.selectCount(queryWrapper) > 0;
    }

    /**
     * 查询部门下是否有某用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean hasUserOfDepartment(Long id) {
        // 创建条件查询构造器对象
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<UserPO>();
        queryWrapper.eq("department_id", id);     // 判断部门下是否有用户
        return userMapper.selectCount(queryWrapper) > 0;
    }

    /**
     * 根据部门名查询部门
     *
     * @param departmentName
     * @return
     */
    @Override
    public DepartmentPO getDepartmentByName(String departmentName) {
        QueryWrapper<DepartmentPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("department_name", departmentName);
        return baseMapper.selectOne(queryWrapper);
    }
}
