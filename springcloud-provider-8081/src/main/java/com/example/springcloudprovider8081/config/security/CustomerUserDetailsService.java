
package com.example.springcloudprovider8081.config.security;

import com.example.springcloudprovider8081.service.PermissionService;
import com.example.springcloudprovider8081.service.UserService;
import com.example.springcloudprovider8081.entity.po.PermissionPO;
import com.example.springcloudprovider8081.entity.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户认证处理类，主要用于从数据库查询用户信息
 * @author wuhu
 */
@Slf4j
@Component
public class CustomerUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername username: {}", username);
        // 根据用户名查询用户
        UserPO user = userService.getUserByUsername(username);
        // 如果对象为空，则认证失败
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 查询用户拥有的权限列表
        List<PermissionPO> permissions = permissionService.findPermissionListByUserId(user.getId());
        // 获取权限编码
        List<String> collect = permissions.stream()
                .filter(item -> item != null)
                .map(item -> item.getCode()).filter(item -> item != null)
                .collect(Collectors.toList());
        // 转化为数组
        String[] strings = collect.toArray(new String[collect.size()]);
        // 设置权限列表
        List<GrantedAuthority> authorityList =
                AuthorityUtils.createAuthorityList(strings);
        user.setAuthorities(authorityList);
        // 设置菜单列表
        user.setPermissionList(permissions);

        // 返回UserDetails对象
        return user;
    }
}