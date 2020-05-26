package com.github.mysql.listener;


import com.github.mysql.pojo.UserSaveEvent;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author shao
 */
@Slf4j
@Component
public class UserInfoListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void userInfoSave2(@NotNull UserSaveEvent userInfo) {
        log.error("userInfoSave2-username:{}", userInfo.getId());
    }

}
