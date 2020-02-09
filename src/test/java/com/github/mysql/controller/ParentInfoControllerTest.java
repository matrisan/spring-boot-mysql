package com.github.mysql.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mysql.pojo.OneToOneChildrenInfoDO;
import com.github.mysql.pojo.OneToOneParentInfoDO;
import com.github.mysql.repository.IChildrenInfoRepository;
import com.github.mysql.repository.IParentInfoRepository;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
public class ParentInfoControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private IChildrenInfoRepository repository;

    @Resource
    private IParentInfoRepository personDoRepository;

    private Integer personId;

    @Before
    public void setUp() {
        OneToOneChildrenInfoDO toSaveAddr = new OneToOneChildrenInfoDO();
        toSaveAddr.setAddress("Jiang Su");
        toSaveAddr.setName("address name");

        OneToOneChildrenInfoDO oneToOneChildrenInfoDO = repository.save(toSaveAddr);

        OneToOneParentInfoDO oneToOneParentInfoDO = new OneToOneParentInfoDO();
        oneToOneParentInfoDO.setAge(18);
        oneToOneParentInfoDO.setUsername("person name");
        oneToOneParentInfoDO.setAddressId(oneToOneChildrenInfoDO.getId());

        personId = personDoRepository.save(oneToOneParentInfoDO).getId();
    }

    @After
    public void tearDown() {
        personDoRepository.deleteById(personId);
    }

    @Test
    @SneakyThrows(Exception.class)
    public void getById() {
        mockMvc.perform(MockMvcRequestBuilders.get("/parent/" + personId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/parent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(getParent())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private OneToOneParentInfoDO getParent() {
        OneToOneParentInfoDO oneToOneParentInfoDO = new OneToOneParentInfoDO();
        oneToOneParentInfoDO.setAge(18);
        oneToOneParentInfoDO.setUsername("person name");
        oneToOneParentInfoDO.setAddress(getChildren());
        return oneToOneParentInfoDO;
    }


    private OneToOneChildrenInfoDO getChildren() {
        OneToOneChildrenInfoDO toSaveAddr = new OneToOneChildrenInfoDO();
        toSaveAddr.setAddress("Jiang Su");
        toSaveAddr.setName("address name");
        return toSaveAddr;
    }

}













