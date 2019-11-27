package com.github.mysql.ainit;

import com.github.mysql.pojo.UserIndexDO;
import com.github.mysql.repository.IUserIndexRepository;
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
    private IUserIndexRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        for (int i = 0; i < 10; i++) {
            UserIndexDO userIndexDO = UserIndexDO.builder()
                    .roleName("name:" + i)
                    .role("role:" + i)
                    .build();
            repository.save(userIndexDO);
        }
    }

}
