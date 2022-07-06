
package com.example.springcloudprovider8081.entity.vo;

import com.example.springcloudprovider8081.entity.po.UserPO;
import lombok.Data;

@Data
public class UserVO extends UserPO {

    private Long pageNo = 1L; // 当前页
    private Long pageSize = 10L; // 每页显示条数

}