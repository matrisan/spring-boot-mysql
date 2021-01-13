package com.github.mysql.repository;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

@DirtiesContext
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@SpringBootTest
public class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository repository;

    @Test
    public void updateAge() throws Exception {
        int num = repository.updateAge(10, "name:11");
        System.out.println(num);
    }


}