package com.github.mysql.repository;

import com.github.mysql.pojo.SystemUserRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 上午10:27 2020/2/7
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemUserRoleRepository extends JpaRepository<SystemUserRoleDO, Long> {
}
