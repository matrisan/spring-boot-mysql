package com.github.mysql.schedule;

import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-12-15 11:26
 * @since 1.0
 */

@Slf4j
@Component
public class AddSchedule {

    @Resource
    private IUserInfoRepository repository;

    private int a = 0;

    @Scheduled(fixedDelay = 1000)
    public void deleteDeprecatedData() {
        UserInfoDO userInfoDO = UserInfoDO.builder()
                .username("name:" + System.currentTimeMillis())
                .age(a++)
                .build();
        repository.save(userInfoDO);
        log.info("新增数据 - {}", userInfoDO.toString());
    }
}
