package com.github.mysql.controller;


import com.github.mysql.pojo.CorpDepartmentDO;
import com.github.mysql.repository.ICorpDepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CorpDepartmentController {

    @Resource
    private ICorpDepartmentRepository repository;

    @GetMapping("/department/{id}")
    public CorpDepartmentDO getDepartment(@PathVariable Integer id) {
        return repository.findById(id).orElseGet(CorpDepartmentDO::new);
    }

    @PostMapping("/department")
    public CorpDepartmentDO save(@RequestBody CorpDepartmentDO department) {
        return repository.save(department);
    }

}
