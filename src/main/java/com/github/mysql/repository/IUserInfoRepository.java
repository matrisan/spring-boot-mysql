package com.github.mysql.repository;

import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.pojo.vo.UserInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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

    /**
     * @param username 用户名
     * @return UserInfoDO
     */
    UserInfoDO findByUsernameEquals(String username);

    /**
     * @return Set
     */
    @Query("SELECT user.username FROM UserInfoDO AS user")
    Set<String> findAllRoles();

    /**
     * @return Set
     */
    @Query("SELECT user.username FROM UserInfoDO AS user")
    Page<String> findAllRoles(Pageable pageable);

    /**
     * 更新加10
     *
     * @param username 用户名
     * @param age      年龄
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE UserInfoDO AS user SET user.age = (user.age + :age) WHERE user.username=:username")
    void updateAge(@Param("username") String username, @Param("age") int age);

    @Query("SELECT new com.github.mysql.pojo.vo.UserInfoVO(user.username, user.age) FROM UserInfoDO AS user WHERE user.username=:username")
    UserInfoVO findByUsername(@Param("username") String username);

//    @Query("FROM UserInfoDO AS user WHERE user.username IN (SELECT res.username FROM ResInfoDO AS res)")
//    Set<UserInfoDO> findByUsernameIn();

}
