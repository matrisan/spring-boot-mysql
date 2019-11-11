package com.github.mysql;

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
public class SpringBootMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMysqlApplication.class, args);
    }

}
