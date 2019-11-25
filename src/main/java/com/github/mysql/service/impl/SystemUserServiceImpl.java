package com.github.mysql.service.impl;

import com.github.mysql.pojo.ManyToManyUserDO;
import com.github.mysql.repository.ISystemUserRepository;
import com.github.mysql.service.ISystemUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午10:04 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Resource
    private ISystemUserRepository repository;

    @Override
    public ManyToManyUserDO findOneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ManyToManyUserDO save(ManyToManyUserDO manyToManyUserDO) {
        return repository.save(manyToManyUserDO);
    }

}
