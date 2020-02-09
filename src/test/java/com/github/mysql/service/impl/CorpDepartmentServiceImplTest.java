//package com.github.mysql.service.impl;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.mysql.pojo.OneToManyDepartmentDO;
//import com.github.mysql.pojo.OneToManyEmployeeDO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * <p>
// * 创建时间为 下午9:05 2019/10/21
// * 项目名称 spring-boot-mysql
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@DirtiesContext
//@AutoConfigureMockMvc
//@ActiveProfiles("junit")
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CorpDepartmentServiceImplTest {
//
//    @Resource
//    private ICorpEmployeeService employeeService;
//
//    @Resource
//    private ICorpDepartmentService departmentService;
//
//    @Resource
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void findById() {
//
//        OneToManyDepartmentDO oneToManyDepartmentDO = departmentService.findById(1L);
//        System.out.println(oneToManyDepartmentDO.toString());
//
//    }
//
//    @Test
//    public void findAll() {
//
//        Page<OneToManyDepartmentDO> page = departmentService.findAll(PageRequest.of(0, 10));
//        page.stream().forEach(one -> {
//            try {
//                System.out.println(objectMapper.writeValueAsString(one));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    @Test
//    public void save() {
//        OneToManyEmployeeDO employeeDO = OneToManyEmployeeDO.builder().eName("test_emp_01").build();
//        OneToManyDepartmentDO departmentDO = OneToManyDepartmentDO.builder().build();
//        departmentDO.setDName("test_dep_01");
//        Set<OneToManyEmployeeDO> set = new HashSet<>();
//        set.add(employeeDO);
//        departmentDO.setEmployees(set);
//        employeeService.save(employeeDO);
//        departmentService.save(departmentDO);
//    }
//
//
//}