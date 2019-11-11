package com.github.mysql.service;

import com.github.mysql.pojo.UserCustomerDO;

/**
 * <p>
 * 创建时间为 上午12:14 2019/11/6
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserCustomerService {

    UserCustomerDO create(UserCustomerDO userCustomerDO);

    UserCustomerDO update(UserCustomerDO userCustomerDO);

    void deleteById(long id);

}
