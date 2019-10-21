package com.github.mysql.controller;

import com.github.mysql.pojo.PersonAddressDO;
import com.github.mysql.pojo.PersonInfoDO;
import com.github.mysql.repository.IPersonAddressDoRepository;
import com.github.mysql.repository.IPersonInfoDoRepository;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 上午11:20 2019/9/11
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
public class PersonInfoDoControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private IPersonAddressDoRepository repository;

    @Resource
    private IPersonInfoDoRepository personDoRepository;

    private Integer personId;

    @Before
    @SneakyThrows(Exception.class)
    public void setUp() {
        PersonAddressDO toSaveAddr = new PersonAddressDO();
        toSaveAddr.setAddress("jiangsu");
        toSaveAddr.setName("address name");
        PersonAddressDO personAddressDO = repository.save(toSaveAddr);

        PersonInfoDO personInfoDO = new PersonInfoDO();
        personInfoDO.setAge(18);
        personInfoDO.setUsername("person name");
        personInfoDO.setAddressId(personAddressDO.getId());
        personId = personDoRepository.save(personInfoDO).getId();
    }

    @After
    public void tearDown() throws Exception {
        personDoRepository.deleteById(personId);
    }

    @Test
    @SneakyThrows(Exception.class)
    public void getById() {
        mockMvc.perform(MockMvcRequestBuilders.get("/person/" + personId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void save() {
    }

}













