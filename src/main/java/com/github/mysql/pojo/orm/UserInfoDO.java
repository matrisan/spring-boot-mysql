package com.github.mysql.pojo.orm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(
        name = "UserInfoDO",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}, name = "IDX_UNIQUE_NAME")}
)
@DynamicInsert
@DynamicUpdate
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = -2204556400282928461L;

    @Column(name = "username", nullable = false, columnDefinition = "varchar(100) default '默认名字' comment '我是username注释'")
    private String username;

    @Column(name = "age", nullable = false, columnDefinition = "INT(11) default 18 comment '我是age注释'")
    private Integer age;

    @MapKey
    @JoinTable(
            name = "system_user_role",
            joinColumns = {@JoinColumn(name = "mid_user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "id")}
    )
    @ManyToMany(targetEntity = RoleInfoDO.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Map<Long, RoleInfoDO> roles;

}


