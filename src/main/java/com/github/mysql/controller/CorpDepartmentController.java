package com.github.mysql.controller;


import com.github.mysql.pojo.OneToManyDepartmentDO;
import com.github.mysql.repository.ICorpDepartmentRepository;
import com.github.mysql.service.ICorpDepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CorpDepartmentController {

    @Resource
    private ICorpDepartmentService service;

    @Resource
    private ICorpDepartmentRepository repository;

    @GetMapping("/departments")
    public List<OneToManyDepartmentDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/department/{id}")
    public OneToManyDepartmentDO getDepartment(@PathVariable("id") OneToManyDepartmentDO oneToManyDepartmentDO) {
        return oneToManyDepartmentDO;
    }

    @PostMapping("/department")
    public OneToManyDepartmentDO create(@RequestBody OneToManyDepartmentDO department) {
        return service.save(department);
    }

    @PutMapping("/department")
    public OneToManyDepartmentDO update(@RequestBody OneToManyDepartmentDO department) {
        return service.save(department);
    }

    @DeleteMapping("/department/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}
