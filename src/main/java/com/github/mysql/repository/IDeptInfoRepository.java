package com.github.mysql.repository;


import com.github.mysql.pojo.orm.DeptInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 创建时间为 15:54 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IDeptInfoRepository extends JpaSpecificationExecutor<DeptInfoDO>, JpaRepository<DeptInfoDO, Integer> {

//    /**
//     * 更新用户密码,不知道为什么只有原生 SQL 才能生效
//     *
//     * @param username 用户名
//     * @param password 密码
//     */
//    @Modifying
//    @Query(value = "UPDATE table_userinfo u SET u.password = ?2 WHERE u.username = ?1", nativeQuery = true)
//    void updatePasswordByUsername(String username, String password);


}



