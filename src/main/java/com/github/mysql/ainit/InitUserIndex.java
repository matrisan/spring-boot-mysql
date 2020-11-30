package com.github.mysql.ainit;

import com.github.mysql.pojo.bo.AddressBO;
import com.github.mysql.pojo.bo.RoleInfoBO;
import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>
 * 创建时间为 上午11:13 2019/9/19
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
@RequiredArgsConstructor
public class InitUserIndex {

    private final IUserInfoRepository userInfoRepository;

    @PostConstruct
    public void init() {
        userInfoRepository.deleteAll();
        RoleInfoBO roleInfo1 = (RoleInfoBO.builder().roleName("role-test1").build());
        RoleInfoBO roleInfo2 = (RoleInfoBO.builder().roleName("role-test2").build());
        RoleInfoBO roleInfo3 = (RoleInfoBO.builder().roleName("role-test3").build());
        List<RoleInfoBO> list = Lists.newArrayList(roleInfo1, roleInfo2, roleInfo3);

        for (int i = 0; i < 10; i++) {
            UserInfoDO userInfoDO = UserInfoDO.builder()
                    .username("name:" + i)
                    .roles(Sets.newHashSet(list))
                    .address(AddressBO.builder().name("address:" + i).path("path:" + i).build())
                    .age(i)
                    .build();
            userInfoRepository.save(userInfoDO);
        }
    }

}
