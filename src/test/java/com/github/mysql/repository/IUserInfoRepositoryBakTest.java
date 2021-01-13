package com.github.mysql.repository;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.Set;


/**
 * <p>
 * 创建时间为 下午10:11 2019/11/26
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IUserInfoRepositoryBakTest {

    @Resource
    private IUserInfoRepository repository;


    @Test
    public void findAllTest() {
//        Collection<UserInfoVO> set = repository.findAll(UserInfoVO.class);
//        set.forEach(System.out::println);
    }

    @Test
    public void saveTest() {
//        UserInfoDO userInfoDO1 = UserInfoDO.builder().username("name1").role("role1").build();
//        UserInfoDO userInfoDO2 = UserInfoDO.builder().username("name2").role("role1").build();
//        repository.save(userInfoDO1);
//        userIndexDO.setName("name2");
//        repository.save(userInfoDO2);
    }

    @Test
    public void findAllRoles() {
        Set<String> set = repository.findAllRoles();
        set.forEach(System.out::println);
    }

    @Test
    public void updateAge() {
        String username = "name:0";
        System.out.println(repository.findByUsernameEquals(username));
        repository.updateAge(username, 10);
        System.out.println(repository.findByUsernameEquals(username));
    }


}