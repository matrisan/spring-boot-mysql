package com.github.mysql.repository;

import com.github.mysql.pojo.SystemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午9:28 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemOrderRepository extends JpaRepository<SystemOrder, Long> {
}
