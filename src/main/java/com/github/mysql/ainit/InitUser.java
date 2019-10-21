//package com.github.mysql.ainit;
//
//import com.github.mysql.pojo.UserInfoDO;
//import com.github.mysql.repository.IUserDoRepository;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
///**
// * <p>
// * 创建时间为 上午10:18 2019/9/19
// * 项目名称 spring-boot-mysql
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
////@Component
//public class InitUser {
//
//    @Resource
//    private IUserDoRepository repository;
//
//    @PostConstruct
//    public void init() {
//        repository.deleteAll();
//        for (int i = 0; i < 8; i++) {
//            UserInfoDO userInfoDO = new UserInfoDO();
//            userInfoDO.setUsername("name:" + i);
//            userInfoDO.setGender(UserInfoDO.Gender.MAIL);
//            repository.save(userInfoDO);
//        }
//    }
//
//}
