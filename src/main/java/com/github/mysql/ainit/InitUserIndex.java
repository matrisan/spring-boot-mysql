package com.github.mysql.ainit;

import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

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
public class InitUserIndex {

    @Resource
    private IUserInfoRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        for (int i = 0; i < 10; i++) {
            UserInfoDO userInfoDO = UserInfoDO.builder()
                    .username("name:" + i)
                    .role("role:" + i)
                    .build();
            repository.save(userInfoDO);
        }
    }

}
