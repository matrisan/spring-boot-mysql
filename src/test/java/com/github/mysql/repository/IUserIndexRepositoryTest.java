//package com.github.mysql.repository;
//
//import com.github.mysql.pojo.UserIndexDO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//
//
///**
// * <p>
// * 创建时间为 下午10:11 2019/11/26
// * 项目名称 spring-boot-mysql
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//
//@DirtiesContext
//@AutoConfigureMockMvc
//@ActiveProfiles("junit")
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class IUserIndexRepositoryTest {
//
//    @Resource
//    private IUserIndexRepository repository;
//
//    @Test
//    public void saveTest() {
//        UserIndexDO userIndexDO1 = UserIndexDO.builder().roleName("name1").role("role1").build();
//        UserIndexDO userIndexDO2 = UserIndexDO.builder().roleName("name2").role("role1").build();
//        repository.save(userIndexDO1);
////        userIndexDO.setName("name2");
//        repository.save(userIndexDO2);
//    }
//
//}