package com.github.mysql.repository;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.pojo.ManyToManyUserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * <p>
 * 创建时间为 上午9:58 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemUserRepository extends JpaSpecificationExecutor<ManyToManyUserDO>, JpaRepository<ManyToManyUserDO, Long> {

    @Query("SELECT user.roles FROM ManyToManyUserDO user WHERE user.userId = :id")
    Page<ManyToManyRoleDO> findAllRole(@Param("id") Long id, Pageable pageable);

    @Query("SELECT role FROM ManyToManyRoleDO role WHERE :user MEMBER OF role.users")
    Page<ManyToManyRoleDO> findAllRole2(@Param("user") ManyToManyUserDO user, Pageable pageable);


}
