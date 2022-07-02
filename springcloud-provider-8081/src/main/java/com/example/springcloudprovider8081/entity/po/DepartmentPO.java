<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_department")
public class DepartmentPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门电话
     */
    private String phone;

    /**
     * 部门地址
     */
    private String address;

    /**
     * 所属部门编号
     */
    private Long pid;

    /**
     * 所属部门名称
     */
    private String parentName;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否删除(0-未删除 1-已删除)
     */
    private Integer isDelete;

    /**
     * 是否展开
     */
    @TableField(exist = false)
    private Boolean open;

    /**
     * 子部门
     */
    @TableField(exist = false)
    private List<DepartmentPO> children = new ArrayList<DepartmentPO>();
}
=======
package com.example.springcloudprovider8081.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_department")
public class DepartmentPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门电话
     */
    private String phone;

    /**
     * 部门地址
     */
    private String address;

    /**
     * 所属部门编号
     */
    private Long pid;

    /**
     * 所属部门名称
     */
    private String parentName;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否删除(0-未删除 1-已删除)
     */
    private Integer isDelete;

    /**
     * 是否展开
     */
    @TableField(exist = false)
    private Boolean open;

    /**
     * 子部门
     */
    @TableField(exist = false)
    private List<DepartmentPO> children = new ArrayList<DepartmentPO>();
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
