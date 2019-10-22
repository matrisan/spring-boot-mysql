package com.github.mysql.service.impl;

import com.github.mysql.pojo.DateTimeDO;
import com.github.mysql.service.IDateTimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 上午10:56 2019/10/22
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
public class DateTimeServiceImplTest {

    @Resource
    private IDateTimeService service;

    @Test
    public void save() {
        Date date = new Date();
        DateTimeDO dateTimeDO = DateTimeDO.builder()
                .note("测试时间!")
                .date(date)
                .time(date)
                .timestamp(date)
                .build();
        service.save(dateTimeDO);
    }


}