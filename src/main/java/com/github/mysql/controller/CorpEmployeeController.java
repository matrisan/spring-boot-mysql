package com.github.mysql.controller;


import com.github.mysql.pojo.CorpEmployeeDO;
import com.github.mysql.repository.ICorpEmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 00:35 2019-07-04
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class CorpEmployeeController {

    @Resource
    private ICorpEmployeeRepository repository;

    @PostMapping("employee")
    public CorpEmployeeDO save(@RequestBody CorpEmployeeDO employee) {
        return repository.save(employee);
    }

}
