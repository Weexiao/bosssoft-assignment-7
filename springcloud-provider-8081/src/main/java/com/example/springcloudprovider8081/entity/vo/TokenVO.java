
package com.example.springcloudprovider8081.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenVO {
    // 过期时间
    private Long expireTime;
    // token
    private String token;
}