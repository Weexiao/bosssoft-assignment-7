<<<<<<< HEAD
package com.example.springcloudprovider8081.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    //存缓存
    public void set(String key ,String value,Long timeOut){
        log.info("redis存储数据成功");
        redisTemplate.opsForValue().set(key,value,timeOut, TimeUnit.SECONDS);
    }
    //取缓存
    public String get(String key){
        log.info("redis取出数据成功");
        return (String) redisTemplate.opsForValue().get(key);
    }
    //清除缓存
    public void del(String key){
        log.info("redis删除数据成功");
        redisTemplate.delete(key);
    }
=======
package com.example.springcloudprovider8081.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    //存缓存
    public void set(String key ,String value,Long timeOut){
        log.info("redis存储数据成功");
        redisTemplate.opsForValue().set(key,value,timeOut, TimeUnit.SECONDS);
    }
    //取缓存
    public String get(String key){
        log.info("redis取出数据成功");
        return (String) redisTemplate.opsForValue().get(key);
    }
    //清除缓存
    public void del(String key){
        log.info("redis删除数据成功");
        redisTemplate.delete(key);
    }
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
}