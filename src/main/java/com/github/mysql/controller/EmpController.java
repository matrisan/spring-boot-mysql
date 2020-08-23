package com.github.mysql.controller;


import com.github.mysql.pojo.table.EmpDO;
import com.github.mysql.repository.IEmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequiredArgsConstructor
public class EmpController {

    private final IEmpRepository repository;

    @GetMapping("emps")
    public List<EmpDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("emp")
    public EmpDO create(@RequestBody EmpDO emp) {
        return repository.save(emp);
    }

    @PutMapping("emp/{empId}")
    public EmpDO update(@PathVariable("empId") EmpDO emp,@RequestBody EmpDO emp) {
        return repository.save(emp);
    }

    @DeleteMapping("emp/{empId}")
    public EmpDO deleteById(@PathVariable("empId") EmpDO emp) {
        return emp;
    }

}
