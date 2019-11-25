package com.github.mysql.controller;


import com.github.mysql.pojo.OneToManyDepartmentDO;
import com.github.mysql.service.ICorpDepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/department")
@RestController
public class CorpDepartmentController {

    @Resource
    private ICorpDepartmentService service;

    @GetMapping("/{departmentId}")
    public OneToManyDepartmentDO getDepartment(@PathVariable("departmentId") OneToManyDepartmentDO oneToManyDepartmentDO) {
        return oneToManyDepartmentDO;
    }

    @GetMapping("/departments")
    public Page<OneToManyDepartmentDO> findAll(@PageableDefault(size = 4, page = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return service.findAll(pageable);
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
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }


}
