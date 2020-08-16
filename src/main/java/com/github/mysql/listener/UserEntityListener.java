package com.github.mysql.listener;

import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.service.UserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * @author 石少东
 * @date 2020-06-18 23:31
 * @since 1.0
 */

@Slf4j
@Setter(onMethod=@__(@Autowired))
//@Configurable
public class UserEntityListener {

    private ObjectFactory<UserService> handler;

    public void setUserService(ObjectFactory<UserService>  userService) {
        Assert.notNull(userService, "AuditingHandler must not be null!");
        this.handler = userService;
    }


    /**
     * 保存前
     *
     * @param student UserInfoDO
     */
    @PrePersist
    public void prePersist(@NotNull UserInfoDO student) {
        handler.getObject().print(student);
        log.info("保存前" + student.toString());
    }

    /**
     * 保存后
     *
     * @param student UserInfoDO
     */
    @PostPersist
    public void postPersist(@NotNull UserInfoDO student) {
//        service.print(student);

        log.info("保存后" + student.toString());
    }

    /**
     * 删除前
     *
     * @param student UserInfoDO
     */
    @PreRemove
    public void preRemove(@NotNull UserInfoDO student) {
        log.info("删除前" + student.toString());
    }

    /**
     * 删除后
     *
     * @param student UserInfoDO
     */
    @PostRemove
    public void postRemove(@NotNull UserInfoDO student) {
        log.info("删除后" + student.toString());
    }

    /**
     * 更新前
     *
     * @param student UserInfoDO
     */
    @PreUpdate
    public void preUpdate(@NotNull UserInfoDO student) {
        log.info("更新前" + student.toString());
    }

    /**
     * 更新后
     *
     * @param student UserInfoDO
     */
    @PostUpdate
    public void postUpdate(@NotNull UserInfoDO student) {
        log.info("更新后" + student.toString());
    }

    /**
     * 查询后
     *
     * @param student UserInfoDO
     */
    @PostLoad
    public void postLoad(@NotNull UserInfoDO student) {
        log.info("查询后" + student.toString());
    }


}
