package com.github.mysql.schedule;

import com.github.mysql.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 石少东
 * @date 2020-12-15 11:26
 * @since 1.0
 */

@Slf4j
@Component
public class DeleteSchedule {

    @Resource
    private IUserInfoRepository repository;

    @Scheduled(fixedDelay = 10 * 1000)
    public void deleteDeprecatedData() {
        Date date = DateTime.now().minusSeconds(10).toDate();
        log.info("删除 10S 之前的数据 - {}", repository.deleteByCreateDateBefore(date));
    }
}
