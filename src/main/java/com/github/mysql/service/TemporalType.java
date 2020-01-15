package com.github.mysql.service;

import com.github.mysql.pojo.TemporalTypeDO;
import com.github.mysql.repository.ITemporalTypeRepository;
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
public class TemporalType {

    @Resource
    private ITemporalTypeRepository repository;

    public TemporalTypeDO save(TemporalTypeDO temporalTypeDO) {
        return repository.save(temporalTypeDO);
    }

}
