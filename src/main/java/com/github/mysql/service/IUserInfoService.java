package com.github.mysql.service;

import com.github.mysql.pojo.UserInfoDO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:11 2019/10/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserInfoService {

    UserInfoDO save(UserInfoDO userInfoDO);

    UserInfoDO txSave(UserInfoDO userInfoDO);

    void updatePasswordByUsername(String username, String password);

    UserInfoDO findByUsernameEqual(String username);

    UserInfoDO findByUsernameAndPassword(String username, String password);

    List<UserInfoDO> findAllLike(String username);

}
