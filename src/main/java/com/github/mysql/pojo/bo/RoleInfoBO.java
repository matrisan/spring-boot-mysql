package com.github.mysql.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午10:01 2019/11/26
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoBO implements Serializable {

    private static final long serialVersionUID = -8807482859115915839L;

    private String roleName;

    private String roleCode;

}


