//package com.github.mysql.ainit;
//
//import com.github.mysql.pojo.orm.RoleInfoDO;
//import com.github.mysql.pojo.orm.UserInfoDO;
//import com.github.mysql.pojo.orm.mid.UserRoleDO;
//import com.github.mysql.repository.IMidRepository;
//import com.github.mysql.repository.IRoleInfoRepository;
//import com.github.mysql.repository.IUserInfoRepository;
//import com.google.common.collect.Sets;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
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
//public class InitUserIndex {
//
//    @Resource
//    private IUserInfoRepository userInfoRepository;
//
//    @Resource
//    private IRoleInfoRepository roleInfoRepository;
//
//    @Resource
////    private IMidRepository midRepository;
//
//    @PostConstruct
//    public void init() throws Exception {
//        userInfoRepository.deleteAll();
//        for (int i = 0; i < 10; i++) {
//            UserInfoDO userInfoDO = userInfoRepository.save(
//                    UserInfoDO.builder().username("name:" + i).build()
//            );
//            RoleInfoDO roleInfoDO = roleInfoRepository.save(
//                    RoleInfoDO.builder().roleName("name:" + i).build()
//            );
//            UserRoleDO userRoleDO = midRepository.save(
//                    UserRoleDO.builder()
//                            .user(userInfoDO)
//                            .role(roleInfoDO)
//                            .build());
//        }
//    }
//
//    private RoleInfoDO getRoleInfo(int i) {
//        return RoleInfoDO.builder().roleName("role:" + i).build();
//    }
//
//}
