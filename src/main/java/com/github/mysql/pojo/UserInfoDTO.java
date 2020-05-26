package com.github.mysql.pojo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 创建时间为 下午4:32 2020/4/21
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
public class UserInfoDTO {

    private String username;

    private Integer age;

    private String role;

}
