package com.github.mysql.event.handler;

import com.github.mysql.pojo.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.client.RestTemplate;

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

@Slf4j
@Component
public class UserInfoSaveEventHandler {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    /**
     * 接受User发出的类型为 EventUserSave 的 DomainEvents事件
     *
     * @param event EventUserSave
     */
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void event(@NotNull UserInfoDO event) {
        log.info("TransactionPhase:BEFORE_COMMIT-{}", event.toString());
        if (event.getUsername().contains("error")) {
            REST_TEMPLATE.postForObject("http://www.1111.com", event.toString(), String.class);
        }
    }

}
