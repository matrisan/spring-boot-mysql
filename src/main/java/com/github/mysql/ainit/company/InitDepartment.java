package com.github.mysql.ainit.company;

import com.github.mysql.pojo.orm.company.DepartmentDO;
import com.github.mysql.repository.IDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 石少东
 * @date 2020-07-04 18:44
 * @since 1.0
 */

@Component
@RequiredArgsConstructor
public class InitDepartment {

    private final IDepartmentRepository departmentRepository;

    @PostConstruct
    public void init() {
        DepartmentDO department = DepartmentDO.builder().name("Department").build();
        departmentRepository.save(department);
    }

}
