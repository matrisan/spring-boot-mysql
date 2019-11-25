package com.github.mysql.repository;

import com.github.mysql.pojo.ManyToManyUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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


}
