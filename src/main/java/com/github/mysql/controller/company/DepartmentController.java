package com.github.mysql.controller.company;

import com.github.mysql.pojo.orm.company.DepartmentDO;
import com.github.mysql.repository.IDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 石少东
 * @date 2020-07-04 19:09
 * @since 1.0
 */

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentRepository repository;

    @GetMapping("department")
    public List<DepartmentDO> findAll() {
        return repository.findAll();
    }

}
