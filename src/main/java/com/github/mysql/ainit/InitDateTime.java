package com.github.mysql.ainit;

import com.github.mysql.pojo.TemporalTypeDO;
import com.github.mysql.repository.ITemporalTypeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 上午11:15 2019/9/19
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class InitDateTime {

    @Resource
    private ITemporalTypeRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        for (int i = 0; i < 8; i++) {
            Date date = new Date();
            TemporalTypeDO temporalTypeDO = new TemporalTypeDO();
            temporalTypeDO.setDate(date);
            temporalTypeDO.setTime(date);
            temporalTypeDO.setTimestamp(date);
            repository.save(temporalTypeDO);
        }
    }

}
