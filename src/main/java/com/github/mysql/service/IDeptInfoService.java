package com.github.mysql.service;

import com.github.mysql.pojo.DeptInfoDO;

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

public interface IDeptInfoService {

    DeptInfoDO save(DeptInfoDO deptInfoDO);

    DeptInfoDO txSave(DeptInfoDO deptInfoDO);

//    void updatePasswordByUsername(String username, String password);

    DeptInfoDO findByUsernameEqual(String username);

    DeptInfoDO findByUsernameAndPassword(String username, String password);

    List<DeptInfoDO> findAllLike(String username);

}
