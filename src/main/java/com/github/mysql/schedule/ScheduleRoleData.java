package com.github.mysql.schedule;

import com.github.mysql.pojo.RoleInfoDO;
import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.repository.IRoleInfoRepository;
import com.github.mysql.repository.IUserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 石少东
 * @date 2020-05-27 11:08
 */

@Component
@EnableScheduling
@RequiredArgsConstructor
public class ScheduleRoleData {

    private final IRoleInfoRepository repository;

    @Scheduled(fixedDelay = 1000)
    public void task() {
        repository.save(RoleInfoDO.builder().roleName(new Date().toString()).build());
    }

}
