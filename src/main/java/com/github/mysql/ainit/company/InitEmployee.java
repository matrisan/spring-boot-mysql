package com.github.mysql.ainit.company;

import com.github.mysql.pojo.orm.company.DepartmentDO;
import com.github.mysql.pojo.orm.company.EmployeeDO;
import com.github.mysql.repository.IDepartmentRepository;
import com.github.mysql.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 石少东
 * @date 2020-07-04 18:44
 * @since 1.0
 */

@Component
@DependsOn("initDepartment")
@RequiredArgsConstructor
public class InitEmployee {

    private final IEmployeeRepository repository;

    private final IDepartmentRepository departmentRepository;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            DepartmentDO department = departmentRepository.findAll().get(0);
            EmployeeDO employee = EmployeeDO.builder().empName("name:" + i).department(department).build();
            repository.save(employee);
        }
    }
}
