package com.github.mysql.repository;

import com.github.mysql.pojo.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 创建时间为 下午10:10 2019/11/26
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {


    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE UserInfoDO AS user SET user.age = :age WHERE user.username = :username")
    void updateAgeByUsername(@Param("username") String username,@Param("age") Integer age);

}
