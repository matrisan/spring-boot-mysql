//package com.github.mysql.ainit;
//
//import com.github.mysql.pojo.orm.RoleInfoDO;
//import com.github.mysql.pojo.orm.UserInfoDO;
//import com.github.mysql.repository.IRoleInfoRepository;
//import com.github.mysql.repository.IUserInfoRepository;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Sets;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
///**
// * <p>
// * 创建时间为 上午11:13 2019/9/19
// * 项目名称 spring-boot-mysql
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@Component
//@RequiredArgsConstructor
//public class InitUserIndex {
//
//    private final IUserInfoRepository userInfoRepository;
//
//    private final IRoleInfoRepository roleInfoRepository;
//
//    @PostConstruct
//    public void init() {
//        userInfoRepository.deleteAll();
//        roleInfoRepository.deleteAll();
//        RoleInfoDO roleInfoDO1 = roleInfoRepository.save(RoleInfoDO.builder().roleName("role-test1").build());
//        RoleInfoDO roleInfoDO2 = roleInfoRepository.save(RoleInfoDO.builder().roleName("role-test2").build());
//        RoleInfoDO roleInfoDO3 = roleInfoRepository.save(RoleInfoDO.builder().roleName("role-test3").build());
//        List<RoleInfoDO> list = Lists.newArrayList(roleInfoDO1, roleInfoDO2, roleInfoDO3);
//
//        for (int i = 0; i < 10; i++) {
//            UserInfoDO userInfoDO = UserInfoDO.builder()
//                    .username("name:" + i)
//                    .roles(Sets.newHashSet(list))
//                    .age(i)
//                    .build();
//            userInfoRepository.save(userInfoDO);
//        }
//    }
//
//}
