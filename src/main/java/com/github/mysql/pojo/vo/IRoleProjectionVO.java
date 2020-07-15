package com.github.mysql.pojo.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

/**
 * <p>
 * 创建时间为 下午4:23 2020/5/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IRoleProjectionVO {

    /**
     * 获取角色名
     *
     * @return String
     */
    String getRoleName();

    /**
     * 获取角色Code
     *
     * @return String
     */
    String getRoleCode();

    /**
     * 获取用户
     *
     * @return Set
     */
    @JsonBackReference
    Set<IUserProjectionVO> getUsers();
}
