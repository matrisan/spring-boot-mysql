package com.github.mysql.ainit;

import com.github.mysql.pojo.bo.GroupInfoBO;
import com.github.mysql.pojo.orm.RoleInfoDO;
import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IRoleInfoRepository;
import com.github.mysql.repository.IUserInfoRepository;
import com.google.common.collect.Lists;
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
public class InitRoleIndex {

    private final IRoleInfoRepository roleInfoRepository;

    @PostConstruct
    public void init() {
        roleInfoRepository.deleteAll();
        for (int i = 0; i < 10; i++) {
            RoleInfoDO roleInfo = RoleInfoDO.builder()
                    .roleName("name:" + i)
                    .roleCode("code:" + i)
                    .build();
            roleInfoRepository.save(roleInfo);
        }
    }

}
