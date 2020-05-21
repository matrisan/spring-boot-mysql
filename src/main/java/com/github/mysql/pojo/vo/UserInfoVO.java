package com.github.mysql.pojo.vo;

import lombok.Value;

import java.io.Serializable;

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

@Value
public class UserInfoVO implements Serializable {

    private static final long serialVersionUID = 8795817443828424498L;

    String username;

    Integer age;

//    private Set<RoleInfoVO> roles;

//    public UserInfoVO(String username, Integer age, RoleInfoDO roles) {
//        this.username = username;
//        this.age = age;
//        this.roles.add(getVo(roles));
//    }
//
//    @NotNull
//    private RoleInfoVO getVo(RoleInfoDO role) {
//        RoleInfoVO vo = new RoleInfoVO();
//        BeanUtils.copyProperties(role, vo);
//        return vo;
//    }
}
