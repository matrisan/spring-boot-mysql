package com.github.mysql.controller;


import com.github.mysql.pojo.OneToManyEmployeeDO;
import com.github.mysql.repository.ICorpEmployeeRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("employee")
    public List<OneToManyEmployeeDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("employee")
    public OneToManyEmployeeDO save(@RequestBody OneToManyEmployeeDO employee) {
        return repository.save(employee);
    }

    @PutMapping("employee")
    public OneToManyEmployeeDO update(@RequestBody OneToManyEmployeeDO employee) {
        return repository.save(employee);
    }

    @DeleteMapping("employee")
    public OneToManyEmployeeDO delete(@RequestBody OneToManyEmployeeDO employee) {
        return repository.save(employee);
    }


}
