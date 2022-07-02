<<<<<<< HEAD
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.PermissionPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionVO {

    /**
     * 菜单数据
     */
    private List<PermissionPO> permissionPOList = new ArrayList<>();

    /**
     * 该角色原来分配的菜单数据
     */
    private Object[] checkList;

}
=======
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.PermissionPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionVO {

    /**
     * 菜单数据
     */
    private List<PermissionPO> permissionPOList = new ArrayList<>();

    /**
     * 该角色原来分配的菜单数据
     */
    private Object[] checkList;

}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
