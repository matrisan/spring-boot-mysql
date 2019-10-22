package com.github.mysql.service.impl;

import com.github.mysql.pojo.CorpDepartmentDO;
import com.github.mysql.pojo.CorpEmployeeDO;
import com.github.mysql.service.ICorpDepartmentService;
import com.github.mysql.service.ICorpEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * <p>
 * 创建时间为 下午9:05 2019/10/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@DirtiesContext
@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CorpDepartmentServiceImplTest {

    @Resource
    private ICorpEmployeeService employeeService;

    @Resource
    private ICorpDepartmentService departmentService;

    @Test
    public void save() {

        CorpEmployeeDO employeeDO = CorpEmployeeDO.builder().eName("test_emp_01").build();
        CorpDepartmentDO departmentDO = CorpDepartmentDO.builder().build();

        departmentDO.setDName("test_dep_01");
        Set<CorpEmployeeDO> set = new HashSet<>();
        set.add(employeeDO);
        departmentDO.setEmployees(set);

        employeeService.save(employeeDO);
        departmentService.save(departmentDO);

    }
}