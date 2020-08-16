package com.github.mysql.listener;

import com.github.mysql.pojo.orm.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;

/**
 * @author 石少东
 * @date 2020-06-04 19:50
 */


@Slf4j
@Component
public class EntityEventHandlers {

    @PrePersist
    public void prePersist(@NotNull UserInfoDO userInfo) {
        log.error("PrePersist - {}", userInfo.toString());
    }

}
