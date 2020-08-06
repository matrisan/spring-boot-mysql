package com.github.mysql.ainit;

import com.github.mysql.pojo.orm.RoleInfoDO;
import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IRoleInfoRepository;
import com.github.mysql.repository.IUserInfoRepository;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

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
public class InitUserIndex2 {

    @Resource
    private IUserInfoRepository userInfoRepository;

    @Resource
    private IRoleInfoRepository roleInfoRepository;

    @PostConstruct
    public void init() throws Exception {
//        userInfoRepository.deleteAll();
        for (int i = 0; i < 10; i++) {
            RoleInfoDO roleInfoDO = roleInfoRepository.save(RoleInfoDO.builder().roleName("name:" + i).build());
            Map<Long, RoleInfoDO> roles = Maps.newHashMap();
            roles.put(roleInfoDO.getId(), roleInfoDO);
            UserInfoDO userInfoDO = userInfoRepository.save(
                    UserInfoDO.builder()
                            .username("name:" + i)
                            .age(i)
                            .roles(roles)
                            .build()
            );
        }
    }

    private RoleInfoDO getRoleInfo(int i) {
        return RoleInfoDO.builder().roleName("role:" + i).build();
    }

}
