package com.github.mysql.controller;

import com.alibaba.fastjson.JSON;
import com.github.mysql.pojo.UserCustomerDO;
import lombok.SneakyThrows;
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
 * 创建时间为 上午12:21 2019/11/6
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
public class UserCustomerControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @SneakyThrows(Exception.class)
    public void create() {
        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(getUserCustomer())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @SneakyThrows(Exception.class)
    public void update() {
        mockMvc.perform(MockMvcRequestBuilders.put("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(getUserCustomer())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @SneakyThrows(Exception.class)
    public void deleteById() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private UserCustomerDO getUserCustomer() {
        return UserCustomerDO.builder().name(System.currentTimeMillis() + "").build();
    }

}