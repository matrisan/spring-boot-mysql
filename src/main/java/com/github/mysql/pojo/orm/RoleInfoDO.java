package com.github.mysql.pojo.orm;

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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

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
@EqualsAndHashCode(exclude = "users", callSuper = false)
@Entity
@Table(name = "RoleInfoDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
public class RoleInfoDO extends BaseEntity {

    private static final long serialVersionUID = -8807482859115915839L;

    //    @ColumnDefault("默认名字")
    @Column(name = "role_name", columnDefinition = "varchar(20) default '默认名字' comment '我是roleName注释'")
    private String roleName;

    @Column(name = "role_code", columnDefinition = "varchar(20) default '默认名字' comment '我是roleCode注释'")
    private String roleCode;

    @ManyToMany(targetEntity = UserInfoDO.class, fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH}, mappedBy = "roles")
    private Set<UserInfoDO> users;

}


