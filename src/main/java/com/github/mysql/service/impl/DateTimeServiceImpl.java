package com.github.mysql.service.impl;

import com.github.mysql.pojo.TemporalDateTimeDO;
import com.github.mysql.repository.IDateTimeRepository;
import com.github.mysql.service.IDateTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午10:54 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class DateTimeServiceImpl implements IDateTimeService {

    @Resource
    private IDateTimeRepository repository;

    @Override
    public TemporalDateTimeDO save(TemporalDateTimeDO temporalDateTimeDO) {
        return repository.save(temporalDateTimeDO);
    }

}
