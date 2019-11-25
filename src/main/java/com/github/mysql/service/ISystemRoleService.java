package com.github.mysql.service;

import com.github.mysql.pojo.ManyToManyRoleDO;

/**
 * <p>
 * 创建时间为 上午10:01 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemRoleService {

    ManyToManyRoleDO findOneById(Long id);

    ManyToManyRoleDO save(ManyToManyRoleDO manyToManyRoleDO);

}
