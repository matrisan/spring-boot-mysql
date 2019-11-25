package com.github.mysql.service.impl;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.repository.ISystemRoleRepository;
import com.github.mysql.service.ISystemRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午10:03 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SystemRoleServiceImpl implements ISystemRoleService {

    @Resource
    private ISystemRoleRepository repository;

    @Override
    public ManyToManyRoleDO findOneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ManyToManyRoleDO save(ManyToManyRoleDO manyToManyRoleDO) {
        return repository.save(manyToManyRoleDO);
    }
}
