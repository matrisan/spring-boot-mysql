package com.github.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.mysql.pojo.common.GrantedAuthority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

import static com.github.mysql.pojo.common.SystemAudit.CREATE_BY;
import static com.github.mysql.pojo.common.SystemAudit.CREATE_DATE;
import static com.github.mysql.pojo.common.SystemAudit.LAST_MODIFIED_BY;
import static com.github.mysql.pojo.common.SystemAudit.LAST_MODIFIED_DATE;
import static com.github.mysql.pojo.common.SystemField.MID_RESOURCE_ID;
import static com.github.mysql.pojo.common.SystemField.MID_ROLE_ID;
import static com.github.mysql.pojo.common.SystemField.RESOURCE_ID;
import static com.github.mysql.pojo.common.SystemField.ROLE_ID;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_ROLE;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_ROLE_RESOURCE;

/**
 * <p>
 * 创建时间为 下午10:23 2019/12/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@Builder
@ToString(exclude = {"systemUsers", "systemOrgs"})
@EqualsAndHashCode(exclude = {"systemUsers", "systemOrgs"})
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = SYSTEM_ROLE)
@Where(clause = "deleted = false")
public class SystemRoleDO implements GrantedAuthority {

    private static final long serialVersionUID = 2604553394364576002L;

    @Id
    @Column(name = ROLE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name", columnDefinition = "COMMENT '角色名称'")
    private String roleName;

    /**
     * 角色备注
     */
    @Column(columnDefinition = "COMMENT '角色备注'")
    private String note;

    /**
     * 角色是否删除
     */
    @Column(columnDefinition = " INT(11) DEFAULT 0 COMMENT '是否删除'")
    private Boolean deleted;

    @ManyToMany(mappedBy = "systemRoles")
    private Set<SystemOrgDO> systemOrgs;

    @ManyToMany(mappedBy = "systemRoles")
    private Set<SystemUserDO> systemUsers;

    @ManyToMany(
            targetEntity = SystemResourceDO.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = SYSTEM_ROLE_RESOURCE,
            joinColumns = {@JoinColumn(name = MID_ROLE_ID, referencedColumnName = ROLE_ID)},
            inverseJoinColumns = {@JoinColumn(name = MID_RESOURCE_ID, referencedColumnName = RESOURCE_ID)}
    )
    @JsonIgnoreProperties(value = "systemRoles")
    private Set<SystemResourceDO> systemRess;

    @Override
    public String getAuthority() {
        return roleName;
    }

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = CREATE_DATE)
    private Date createDate;

    /**
     * 最后更新时间
     */
    @LastModifiedDate
    @Column(name = LAST_MODIFIED_DATE)
    private Date lastModifiedDate;

    /**
     * 创建事件
     */
    @CreatedBy
    @Column(name = CREATE_BY)
    private Long createBy;

    /**
     * 最后更新人
     */
    @LastModifiedBy
    @Column(name = LAST_MODIFIED_BY)
    private Long lastModifiedBy;

}
