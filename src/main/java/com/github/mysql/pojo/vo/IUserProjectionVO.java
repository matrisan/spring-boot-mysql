package com.github.mysql.pojo.vo;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p>
 * 创建时间为 下午4:21 2020/5/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserProjectionVO {

    /**
     * 获取用户名
     *
     * @return String
     */
    @Value("#{@usernameMapper.getUsername(target.username)}")
    String getUsername();

    /**
     * 获取年龄
     *
     * @return String
     */
    String getAge();

}
