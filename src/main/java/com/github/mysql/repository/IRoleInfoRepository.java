package com.github.mysql.repository;

import com.github.mysql.pojo.orm.RoleInfoDO;
import com.github.mysql.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

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

    @Query("SELECT role.roleCode FROM RoleInfoDO AS role WHERE role MEMBER OF ")
    Set<String> findAllRoleCode(@Param("user") UserInfoDO userInfo);

}
