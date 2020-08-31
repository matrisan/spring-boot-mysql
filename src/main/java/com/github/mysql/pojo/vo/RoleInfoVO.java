package com.github.mysql.pojo.vo;

import lombok.ToString;
import lombok.Value;

import java.io.Serializable;

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

@Value
@ToString
public class RoleInfoVO implements Serializable {

    private static final long serialVersionUID = -31398461724407736L;

    String roleName;

    String roleCode;

}
