package com.github.mysql.hibernate;

import com.github.mysql.pojo.orm.UserInfoDO;
import io.github.teastman.hibernate.annotation.HibernateEventListener;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Component;

import static io.github.teastman.hibernate.tool.HibernateEventUtils.getPropertyIndex;

/**
 * @author 石少东
 * @date 2020-08-13 16:23
 * @since 1.0
 */

@Slf4j
@Component
public class AppPreUpdateEventListener2  {

    @HibernateEventListener
    public void onSave(UserInfoDO entity, SaveOrUpdateEvent event) {
        int index = getPropertyIndex(event, "name");
//        if (event.getOldState()[index] != event.getState()[index]) {
//            // The name changed.
//        }
    }

    @HibernateEventListener
    public void onUpdate(UserInfoDO entity, PreInsertEvent event) {
        int index = getPropertyIndex(event, "name");
//        if (event.getOldState()[index] != event.getState()[index]) {
//            // The name changed.
//        }
    }
}
