package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * <p>
 * 创建时间为 上午9:46 2019/10/22
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@EqualsAndHashCode(exclude = {"users"})
@Table(name = "system_role")
@Entity(name = "system_role")
@EntityListeners(AuditingEntityListener.class)
public class ManyToManyRoleDO {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    @ManyToMany(targetEntity = ManyToManyUserDO.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "system_user_role",
            joinColumns = {@JoinColumn(name = "system_role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "system_user_id", referencedColumnName = "user_id")}
    )
    private Set<ManyToManyUserDO> users;

}
