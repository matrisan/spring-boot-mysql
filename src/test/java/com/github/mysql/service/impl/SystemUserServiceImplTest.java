//package com.github.mysql.service.impl;
//
//import com.github.mysql.pojo.ManyToManyUserDO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import javax.transaction.Transactional;
//
///**
// * <p>
// * 创建时间为 上午11:26 2019/10/22
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
//public class SystemUserServiceImplTest {
//
//    @Resource
//    private ISystemUserService service;
//
//    @Test
//    @Transactional
//    public void findOneById() {
//        ManyToManyUserDO userDO = service.findOneById(1L);
//
//        userDO.getRoles().forEach(one->System.out.println(one.getRoleName()));
//
////        System.out.println(userDO.toString());
//
//    }
//
//    @Test
//    public void save() {
//    }
//}