package com.github.mysql.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

/**
 * <p>
 * 创建时间为 上午11:23 2020/2/18
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
public class BaseEntity {

    @CreatedDate
    private Date createDate;

}
