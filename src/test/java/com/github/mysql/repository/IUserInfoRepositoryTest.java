package com.github.mysql.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@DirtiesContext
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository repository;

    @Test
    public void findOne() throws Exception {
//        UserInfoDO num = repository.findOne( "123");
//        System.out.println(num);
    }



    @Test
    public void updateAge() throws Exception {
//        int num = repository.updateAge(10, "name:11");
//        System.out.println(num);
    }


}