package com.github.mysql;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shao
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableTransactionManagement
@EnableEncryptableProperties
public class SpringBootMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMysqlApplication.class, args);
    }

}
