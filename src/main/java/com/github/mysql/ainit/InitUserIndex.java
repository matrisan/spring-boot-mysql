package com.github.mysql.ainit;

import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


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
        for (int i = 0; i < 10; i++) {
            UserInfoDO userInfoDO = UserInfoDO.builder()
                    .username("username:" + i)
                    .age(i)
                    .roleInfo(UserInfoDO.RoleInfoBO.builder().roleName("role:" + i).roleDesc("desc:" + i).build())
                    .build();
            userInfoRepository.save(userInfoDO);

        }
    }
}
