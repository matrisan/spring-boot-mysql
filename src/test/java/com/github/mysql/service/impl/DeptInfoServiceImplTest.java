//package com.github.mysql.service.impl;
//
//import com.github.mysql.pojo.orm.DeptInfoDO;
//import com.github.mysql.repository.IDeptInfoRepository;
//import com.github.mysql.service.IDeptInfoService;
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
//import java.util.List;
//
///**
// * <p>
// * 创建时间为 下午1:12 2019/10/21
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
//public class DeptInfoServiceImplTest {
//
//    @Resource
//    private IDeptInfoService service;
//
//    @Resource
//    private IDeptInfoRepository repository;
//
//    @Test
//    public void save() {
//        DeptInfoDO deptInfoDO = DeptInfoDO.builder()
//                .username("TestName02")
//                .password("TestPass02")
//                .gender(DeptInfoDO.Gender.MAIL)
//                .build();
//        service.save(deptInfoDO);
//    }
//
//    @Test
//    public void txSave() {
//
//        System.out.println(repository.count());
//
//        DeptInfoDO deptInfoDO = DeptInfoDO.builder()
//                .username("TestName03")
//                .password("TestPass03")
//                .gender(DeptInfoDO.Gender.MAIL)
//                .build();
//        service.txSave(deptInfoDO);
//
//        System.out.println(repository.count());
//    }
//
//    @Test
//    @Transactional
//    public void updatePasswordByUsername() {
//        service.updatePasswordByUsername("TestName01", "123456");
//    }
//
//    @Test
//    public void findByUsernameAndPassword() {
//        DeptInfoDO deptInfoDO = service.findByUsernameAndPassword("TestName02", "123456");
//        System.out.println(deptInfoDO);
//    }
//
//    @Test
//    public void findAllLike() {
//        List<DeptInfoDO> list = service.findAllLike("TestName%");
//        list.forEach(System.out::println);
//    }
//
//
//}