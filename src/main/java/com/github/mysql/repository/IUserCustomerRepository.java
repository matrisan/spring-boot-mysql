package com.github.mysql.repository;

import com.github.mysql.pojo.UserCustomerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * <p>
 * 创建时间为 上午12:13 2019/11/6
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserCustomerRepository extends JpaRepository<UserCustomerDO, Long> {
}
