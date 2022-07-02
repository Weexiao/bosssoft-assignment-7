<<<<<<< HEAD
package com.example.springcloudprovider8081.config.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.springcloudprovider8081.common.LoginResult;
import com.example.springcloudprovider8081.common.ResultCode;
import com.example.springcloudprovider8081.config.redis.RedisService;
import com.example.springcloudprovider8081.entity.po.UserPO;
import com.example.springcloudprovider8081.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 登录认证成功处理器类
 */
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private RedisService redisService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登录认证成功处理器类配置成功");
        // 设置响应的内容编码格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        // 获取当前登录用户的信息
        UserPO user = (UserPO) authentication.getPrincipal();
        // 生成token令牌
        String token = jwtUtils.generateToken(user);
        // 设置token签名密钥及token过期时间
        long expireTime = Jwts.parser()// 获取DefaultJwtParser对象
                .setSigningKey(jwtUtils.getSecret())// 设置签名密钥
                .parseClaimsJws(token.replace("jwt_", ""))
                .getBody().getExpiration().getTime(); // 获取过期时间
        // 创建登录成功结果对象
        LoginResult loginResult = new LoginResult(user.getId(), ResultCode.SUCCESS, token, expireTime);
        // 将对象转换为Json格式，并消除循环引用
        String result = JSON.toJSONString(loginResult, SerializerFeature.DisableCircularReferenceDetect);
        // 获取输出流
        ServletOutputStream out = httpServletResponse.getOutputStream();
        // 将Json格式的字符串写入输出流
        out.write(result.getBytes(StandardCharsets.UTF_8));
        out.flush();
        // 关闭输出流
        out.close();

        // 将token存入redis
        String tokenKey = "token_" + token;
        redisService.set(tokenKey, token, jwtUtils.getExpiration() / 1000);
    }
}
=======
package com.example.springcloudprovider8081.config.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.springcloudprovider8081.common.LoginResult;
import com.example.springcloudprovider8081.common.ResultCode;
import com.example.springcloudprovider8081.config.redis.RedisService;
import com.example.springcloudprovider8081.entity.po.UserPO;
import com.example.springcloudprovider8081.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 登录认证成功处理器类
 */
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private RedisService redisService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登录认证成功处理器类配置成功");
        // 设置响应的内容编码格式
        httpServletResponse.setContentType("application/json;charset=utf-8");
        // 获取当前登录用户的信息
        UserPO user = (UserPO) authentication.getPrincipal();
        // 生成token令牌
        String token = jwtUtils.generateToken(user);
        // 设置token签名密钥及token过期时间
        long expireTime = Jwts.parser()// 获取DefaultJwtParser对象
                .setSigningKey(jwtUtils.getSecret())// 设置签名密钥
                .parseClaimsJws(token.replace("jwt_", ""))
                .getBody().getExpiration().getTime(); // 获取过期时间
        // 创建登录成功结果对象
        LoginResult loginResult = new LoginResult(user.getId(), ResultCode.SUCCESS, token, expireTime);
        // 将对象转换为Json格式，并消除循环引用
        String result = JSON.toJSONString(loginResult, SerializerFeature.DisableCircularReferenceDetect);
        // 获取输出流
        ServletOutputStream out = httpServletResponse.getOutputStream();
        // 将Json格式的字符串写入输出流
        out.write(result.getBytes(StandardCharsets.UTF_8));
        out.flush();
        // 关闭输出流
        out.close();

        // 将token存入redis
        String tokenKey = "token_" + token;
        redisService.set(tokenKey, token, jwtUtils.getExpiration() / 1000);
    }
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
