package com.github.mysql.repository;

import com.github.mysql.pojo.bo.GroupInfoBO;
import com.github.mysql.pojo.orm.UserInfoDO;
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
     * 分页查询所有的UserInfoDO，并将字段投影到泛型 T 的字段上
     *
     * @param pageable 分页信息
     * @param clz      泛型类型
     * @param <T>      泛型
     * @return Page
     */
    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

    /**
     * 根据用户名查询出所有的用户
     *
     * @param name 用户名
     * @param clz  泛型类型
     * @param <T>  泛型
     * @return Set
     */
    <T> T findByUsername(String name, Class<T> clz);

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

    /**
     * 根据用户新修改 groupInfo
     *
     * @param group    组织信息
     * @param username 用户名
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE UserInfoDO AS user SET user.groupInfo= :groupInfo WHERE user.username=:username")
    void updateGroupInfo(@Param("groupInfo") GroupInfoBO group, @Param("username") String username);

}
