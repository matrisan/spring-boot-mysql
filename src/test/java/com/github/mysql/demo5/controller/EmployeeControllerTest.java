//package com.github.mysql.demo5.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * <p>
// * 创建时间为 00:38 2019-07-04
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
//public class EmployeeControllerTest {
//
//    /**
//     * 模拟mvc测试对象
//     */
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void save() throws Exception {
//        String result = mockMvc.perform(MockMvcRequestBuilders.post("/employee")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(getEmployee().toString()))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        Employee resultDO = new ObjectMapper().readValue(result, Employee.class);
//        System.out.println(result);
//
//    }
//
//
//    private Employee getEmployee() {
//        return Employee
//                .builder()
//                .ename("EmployeeName1")
//                .department(Department
//                        .builder()
//                        .dname("DepartmentName1")
//                        .build())
//                .build();
//    }
//
//
//}