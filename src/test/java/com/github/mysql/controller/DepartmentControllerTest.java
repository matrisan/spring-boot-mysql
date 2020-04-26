//package com.github.mysql.controller;
//
//import com.github.mysql.pojo.depDO;
//import com.github.mysql.pojo.empDO;
//import com.github.mysql.repository.IdepRepository;
//import com.github.mysql.repository.IempRepository;
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
//public class depControllerTest {
//
//    @Resource
//    private MockMvc mockMvc;
//
//    @Resource
//    private IdepRepository depRepository;
//
//    @Resource
//    private IempRepository empRepository;
//
//    private depDO depDO;
//
//    @Before
//    public void setUp() throws Exception {
//        // 创建部门
//        depDO = depRepository.save(getdepDO());
//        //
//        List<empDO> emps = getemps().stream().peek(one -> one.setdep(depDO)).collect(Collectors.toList());
//        empRepository.saveAll(emps);
//    }
//
//    @Test
//    public void getdep() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/dep/" + depDO.getId()))
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
//    private depDO getdepDO() {
//        depDO depDO = new depDO();
//        depDO.setDName("dep1");
//        return depRepository.save(depDO);
//    }
//
//    private List<empDO> getemps() {
//        List<empDO> emps = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            empDO empDO = new empDO();
//            empDO.setEName("name:" + i);
//            emps.add(empDO);
//        }
//        return emps;
//    }
//
//}