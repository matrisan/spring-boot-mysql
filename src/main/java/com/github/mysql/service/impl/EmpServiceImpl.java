package com.github.mysql.service.impl;

import com.github.mysql.pojo.EmpDO;
import com.github.mysql.repository.IEmpRepository;
import com.github.mysql.service.IEmpService;
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
public class EmpServiceImpl implements IEmpService {

    @Resource
    private IEmpRepository repository;

    @Override
    public EmpDO save(EmpDO empDO) {
        return repository.save(empDO);
    }

}
