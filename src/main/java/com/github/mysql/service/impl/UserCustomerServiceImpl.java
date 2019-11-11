package com.github.mysql.service.impl;

import com.github.mysql.pojo.UserCustomerDO;
import com.github.mysql.repository.IUserCustomerRepository;
import com.github.mysql.service.IUserCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午12:16 2019/11/6
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserCustomerServiceImpl implements IUserCustomerService {

    @Resource
    private IUserCustomerRepository repository;

    @Override
    public UserCustomerDO create(UserCustomerDO userCustomerDO) {
        return repository.save(userCustomerDO);
    }

    @Override
    public UserCustomerDO update(UserCustomerDO userCustomerDO) {
        return repository.save(userCustomerDO);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
