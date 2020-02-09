package com.github.mysql.service.impl;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.pojo.ManyToManyUserDO;
import com.github.mysql.pojo.SystemUserRoleDO;
import com.github.mysql.repository.ISystemUserRoleRepository;
import com.github.mysql.service.ISystemRoleService;
import com.github.mysql.service.ISystemUserService;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午10:08 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@DirtiesContext
@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemRoleServiceImplTest {

    @Resource
    private ISystemRoleService roleService;

    @Resource
    private ISystemUserService userService;

    @Resource
    private ISystemUserRoleRepository repository;

    @Test
    public void findOneById() {

    }

    @Test
    public void save() {
        ManyToManyRoleDO manyToManyRoleDO = ManyToManyRoleDO.builder().roleName("ROLE_USER").users(Sets.newHashSet()).build();
        ManyToManyUserDO manyToManyUserDO = ManyToManyUserDO.builder().username("TestUser").roles(Sets.newHashSet()).build();
//        SystemUserRoleDO systemUserRole = SystemUserRoleDO.builder().manyUser(manyToManyUserDO).manyRole(manyToManyRoleDO).build();
        roleService.save(manyToManyRoleDO);
        userService.save(manyToManyUserDO);
//        repository.save(systemUserRole);
    }

}