package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RoleInfoDO")
@DynamicInsert
@DynamicUpdate
public class RoleInfoDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ColumnDefault("默认名字")
    @Column(name = "rolename", columnDefinition = "varchar(100) default '默认名字' comment '我是username注释'")
    private String rolename;

//    @ColumnDefault("18")
    @Column(name = "age", columnDefinition = "INT(11) default 18 comment '我是age注释'")
    private Integer age;

    @Column(name = "note", columnDefinition = "VARCHAR(100) DEFAULT '' COMMENT '我是 note 注释'")
    private String note;
}


