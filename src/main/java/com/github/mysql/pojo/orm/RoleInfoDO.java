package com.github.mysql.pojo.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.mysql.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;
import java.util.Map;

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
@Table(name = "RoleInfoDO")
@DynamicInsert
@DynamicUpdate
public class RoleInfoDO extends BaseEntity {

    private static final long serialVersionUID = 8187760800498783769L;

    //    @ColumnDefault("默认名字")
    @Column(name = "role_name", columnDefinition = "varchar(100) default '默认名字' comment '我是username注释'")
    private String roleName;


    @MapKey
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "roles")
    @JsonBackReference
    private Map<Long, UserInfoDO> users;

}


