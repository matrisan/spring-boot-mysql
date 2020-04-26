package com.github.mysql.controller;


import com.github.mysql.pojo.EmpDO;
import com.github.mysql.repository.IEmpRepository;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class EmpController {

    private final IEmpRepository repository;

    @GetMapping("emp")
    public List<EmpDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("emp")
    public EmpDO save(@RequestBody EmpDO emp) {
        return repository.save(emp);
    }

    @PutMapping("emp")
    public EmpDO update(@RequestBody EmpDO emp) {
        return repository.save(emp);
    }

    @DeleteMapping("emp")
    public EmpDO delete(@RequestBody EmpDO emp) {
        return repository.save(emp);
    }

}
