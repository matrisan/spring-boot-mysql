package com.github.mysql.pojo.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午10:11 2020/5/20
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


public interface IRoleInfoVO {

    String getRoleName();

    String getRoleCode();

    @JsonBackReference
    List<IUserInfoVO> getUsers();

}
