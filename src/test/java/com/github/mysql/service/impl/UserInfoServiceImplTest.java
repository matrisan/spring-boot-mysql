package com.github.mysql.service.impl;

import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:12 2019/10/21
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
public class UserInfoServiceImplTest {

    @Resource
    private IUserInfoService service;

    @Test
    public void save() {
        UserInfoDO userInfoDO = UserInfoDO.builder()
                .username("TestName02")
                .password("TestPass02")
                .gender(UserInfoDO.Gender.MAIL)
                .build();
        service.save(userInfoDO);
    }

    @Test
    @Transactional
    public void updatePasswordByUsername() {
        service.updatePasswordByUsername("TestName01", "123456");
    }

    @Test
    public void findByUsernameAndPassword() {
        UserInfoDO userInfoDO = service.findByUsernameAndPassword("TestName02", "123456");
        System.out.println(userInfoDO);
    }

    @Test
    public void findAllLike() {
        List<UserInfoDO> list = service.findAllLike("TestName%");
        list.forEach(System.out::println);
    }
}