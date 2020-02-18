package com.github.mysql.pojo.common;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午4:44 2020/2/17
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface GrantedAuthority extends Serializable {

    String getAuthority();
}
