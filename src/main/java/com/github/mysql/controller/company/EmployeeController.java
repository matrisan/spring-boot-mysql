package com.github.mysql.controller.company;

import com.github.mysql.pojo.orm.company.EmployeeDO;
import com.github.mysql.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 石少东
 * @date 2020-07-04 19:10
 * @since 1.0
 */

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeRepository repository;

    @GetMapping("employee")
    public List<EmployeeDO> findAll() {
        return repository.findAll();
    }

}
