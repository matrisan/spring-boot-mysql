package com.github.mysql.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 石少东
 * @date 2020-10-27 13:37
 * @since 1.0
 */

@Getter
@Setter
@ToString
public class UserInfoDTO {

    private String username;

    private String mobile;

    private Integer age;

    private String email;


}
