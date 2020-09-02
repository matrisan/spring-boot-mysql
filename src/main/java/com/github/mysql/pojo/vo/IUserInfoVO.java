package com.github.mysql.pojo.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午2:36 2020/3/16
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "UserInfoDO")
public interface IUserInfoVO {

    Long getId();

    String getUsername();

    String getAge();

    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "RoleInfoDO")
    List<IRoleInfoVO> getRoles();
}
