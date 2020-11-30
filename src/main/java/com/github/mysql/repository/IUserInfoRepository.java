package com.github.mysql.repository;

import com.github.mysql.pojo.bo.AddressBO;
import com.github.mysql.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

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

    @Query("SELECT user.address FROM UserInfoDO AS user WHERE user.username = :name")
    AddressBO username(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE UserInfoDO AS user SET user.address = FUNCTION('JSON_REPLACE', user.address,'$.name', :name2) WHERE user.username = :name1")
    int replace(@Param("name1") String name1, @Param("name2") String name2);

}
