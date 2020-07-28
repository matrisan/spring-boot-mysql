package com.github.mysql.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 石少东
 * @date 2020-07-27 19:01
 * @since 1.0
 */


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary",
        //设置Repository所在位置
        basePackages = {"com.github.mysql.repository.primary"}
)
public class PrimarySourceConfig {

    @Resource
    private Environment env;

    @Resource
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return Objects.requireNonNull(entityManagerFactoryPrimary(builder).getObject()).createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(@NotNull EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties())
                .packages("com.github.mysql.pojo.orm.primary")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }


    private @NotNull Map<String, String> getVendorProperties() {
        Map<String, String> jpaProperties = new HashMap<>(16);
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("spring.jpa.hibernate.format_sql"));
        jpaProperties.put("hibernate.dialect", env.getProperty("spring.jpa.hibernate.primary-dialect"));
        jpaProperties.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        return jpaProperties;
    }

    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryPrimary(builder).getObject()));
    }

}

