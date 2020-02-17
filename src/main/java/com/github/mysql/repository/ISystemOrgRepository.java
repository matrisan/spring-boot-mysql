package com.github.mysql.repository;

import com.github.mysql.pojo.SystemOrgDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 上午11:03 2020/2/17
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemOrgRepository extends JpaRepository<SystemOrgDO, Long> {
}
