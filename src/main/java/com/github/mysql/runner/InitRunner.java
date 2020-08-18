package com.github.mysql.runner;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.pojo.ManyToManyUserDO;
import com.github.mysql.repository.ISystemRoleRepository;
import com.github.mysql.repository.ISystemUserRepository;
import com.google.common.collect.Sets;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 创建时间为 上午11:16 2019/9/11
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class InitRunner implements CommandLineRunner {

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemRoleRepository roleRepository;

    int count = 0;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 12; i++) {
            Set<ManyToManyRoleDO> set = Sets.newHashSet();
            for (int i1 = 0; i1 < 12; i1++) {
                ManyToManyRoleDO role = ManyToManyRoleDO.builder().roleName("role:" + ++count).build();
                set.add(roleRepository.save(role));
            }
            ManyToManyUserDO user = ManyToManyUserDO.builder().username("name:" + i).roles(set).build();
            userRepository.save(user);
        }
    }

}
