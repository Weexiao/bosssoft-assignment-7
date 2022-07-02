<<<<<<< HEAD
package com.example.springcloudprovider8081.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //参数1：元数据对象
        // 参数2：属性名称
        // 参数3：类对象
        // 参数4：当前系统时间
        log.info("已自动填充创建时间、更新时间字段");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }

    /**
     * 修改
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("已自动填充更新时间字段");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
=======
package com.example.springcloudprovider8081.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //参数1：元数据对象
        // 参数2：属性名称
        // 参数3：类对象
        // 参数4：当前系统时间
        log.info("已自动填充创建时间、更新时间字段");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }

    /**
     * 修改
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("已自动填充更新时间字段");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
>>>>>>> 437f1fc (注册中心集群 & 基本内容 & OpenFeign负载均衡 & Hystrix熔断机制(自编写Hystrix熔断策略防止ThreadPool无法拿到Request))
