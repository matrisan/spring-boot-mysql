package com.github.mysql.repository;

import com.github.mysql.pojo.bo.GroupInfoBO;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JasyptEncryptorTest {

    @Autowired
    StringEncryptor jasyptStringEncryptor;

    @Test
    public void encrypt() {
        System.out.println("encrypt: " + jasyptStringEncryptor.encrypt("root"));
    }
    @Test
    public void decrypt() {
        System.out.println("decrypt: " + jasyptStringEncryptor.decrypt("o9uLVKcJV4C7SkdF9sZJzQ=="));
    }

}