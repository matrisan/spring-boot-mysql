package com.github.mysql.repository;

import com.github.mysql.pojo.orm.RoleInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午8:44 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IRoleInfoRepository extends JpaRepository<RoleInfoDO, Long> {

}
