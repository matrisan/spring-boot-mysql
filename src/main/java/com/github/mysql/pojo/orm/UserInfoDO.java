package com.github.mysql.pojo.orm;

import com.github.mysql.pojo.BaseEntity;
import com.github.mysql.pojo.bo.GroupInfoBO;
import com.github.mysql.pojo.converter.GroupConverter;
import com.github.mysql.pojo.converter.MobileConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

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

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserInfoDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = 460626250371942731L;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(20) default '默认名字' comment '我是username注释'")
    private String username;

    @Column(name = "age", nullable = false, columnDefinition = "INT(4) default 18 comment '我是age注释'")
    private Integer age;

    @Convert(converter = MobileConverter.class)
    private String mobile;

    @Convert(converter = GroupConverter.class)
    private GroupInfoBO groupInfo;

}


