package com.github.mysql.event.handler;

import com.github.mysql.event.EventUserSave;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * <p>
 * 创建时间为 上午10:56 2019/9/19
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class EventUserSaveHandler {

    /**
     * 接受User发出的类型为 EventUserSave 的DomainEvents事件
     *
     * @param event EventUserSave
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void event(@NotNull EventUserSave event) {
        System.out.println(event.toString());
    }

}
