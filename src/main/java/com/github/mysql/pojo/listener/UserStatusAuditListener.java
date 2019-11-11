package com.github.mysql.pojo.listener;


import com.github.mysql.pojo.DateTimeDO;
import com.github.mysql.pojo.UserCustomerDO;
import com.github.mysql.service.IDateTimeService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * <p>
 * 创建时间为 下午11:13 2019/11/5
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@Component
public class UserStatusAuditListener {

    @Resource
    private IDateTimeService service;

    @PrePersist
    public void prePersist(@NotNull UserCustomerDO object) {
        System.out.println("prePersist " + object.getClass().getName());
        System.out.println(object.toString());

//        service.save(DateTimeDO.builder()
//                .timestamp(new Date())
//                .time(new Date())
//                .date(new Date())
//                .note("note")
//                .build());
    }

    @PreUpdate
    public void preUpdate(@NotNull UserCustomerDO object) {
        System.out.println("preUpdate " + object.getClass().getName());
        System.out.println(object.toString());
    }

    @PreRemove
    public void preRemove(@NotNull UserCustomerDO object) {
        System.out.println("preRemove " + object.getClass().getName());
        System.out.println(object.toString());
    }

    @PostPersist
    public void postPersist(@NotNull UserCustomerDO object) {
        System.out.println("postPersist " + object.getClass().getName());
        System.out.println(object.toString());
    }

    @PostUpdate
    public void postUpdate(@NotNull UserCustomerDO object) {
        System.out.println("postUpdate " + object.getClass().getName());
        System.out.println(object.toString());
    }

    @PostRemove
    public void postRemove(@NotNull UserCustomerDO object) {
        System.out.println("postRemove " + object.getClass().getName());
        System.out.println(object.toString());
    }

    @PostLoad
    public void postLoad(@NotNull UserCustomerDO object) {
        System.out.println("postLoad " + object.getClass().getName());
        System.out.println(object.toString());
    }


}
