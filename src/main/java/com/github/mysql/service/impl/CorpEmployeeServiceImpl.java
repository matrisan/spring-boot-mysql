package com.github.mysql.service.impl;

import com.github.mysql.pojo.CorpEmployeeDO;
import com.github.mysql.repository.ICorpEmployeeRepository;
import com.github.mysql.service.ICorpEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午9:04 2019/10/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CorpEmployeeServiceImpl implements ICorpEmployeeService {

    @Resource
    private ICorpEmployeeRepository repository;

    @Override
    public CorpEmployeeDO save(CorpEmployeeDO corpEmployeeDO) {
        return repository.save(corpEmployeeDO);
    }

}
