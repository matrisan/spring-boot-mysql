//package com.github.mysql.controller;
//
//import com.github.mysql.pojo.DepartmentDO;
//import com.github.mysql.pojo.EmployeeDO;
//import com.github.mysql.repository.IDepartmentRepository;
//import com.github.mysql.repository.IEmployeeRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * <p>
// * 创建时间为 下午4:47 2019/9/12
// * 项目名称 spring-boot-mysql
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@DirtiesContext
//@AutoConfigureMockMvc
//@ActiveProfiles("junit")
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class DepartmentControllerTest {
//
//    @Resource
//    private MockMvc mockMvc;
//
//    @Resource
//    private IDepartmentRepository departmentRepository;
//
//    @Resource
//    private IEmployeeRepository employeeRepository;
//
//    private DepartmentDO departmentDO;
//
//    @Before
//    public void setUp() throws Exception {
//        // 创建部门
//        departmentDO = departmentRepository.save(getDepartmentDO());
//        //
//        List<EmployeeDO> employees = getEmployees().stream().peek(one -> one.setDepartment(departmentDO)).collect(Collectors.toList());
//        employeeRepository.saveAll(employees);
//    }
//
//    @Test
//    public void getDepartment() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/department/" + departmentDO.getId()))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    public void testSave() {
//    }
//
//    private DepartmentDO getDepartmentDO() {
//        DepartmentDO departmentDO = new DepartmentDO();
//        departmentDO.setDName("dep1");
//        return departmentRepository.save(departmentDO);
//    }
//
//    private List<EmployeeDO> getEmployees() {
//        List<EmployeeDO> employees = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            EmployeeDO employeeDO = new EmployeeDO();
//            employeeDO.setEName("name:" + i);
//            employees.add(employeeDO);
//        }
//        return employees;
//    }
//
//}