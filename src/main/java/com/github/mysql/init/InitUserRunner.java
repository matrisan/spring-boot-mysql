package com.github.mysql.init;

import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author 石少东
 * @date 2020-10-27 15:01
 * @since 1.0
 */

@Component
public class InitUserRunner implements CommandLineRunner {

    @Resource
    private IUserInfoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            UserInfoDO user = UserInfoDO.builder()
                    .username(RandomStringUtils.randomAlphabetic(4))
                    .age(random.nextInt(100))
                    .mobile("188" + RandomStringUtils.randomNumeric(8))
                    .email(RandomStringUtils.randomAlphabetic(6) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com")
                    .build();
            repository.save(user);
        }
    }
}
