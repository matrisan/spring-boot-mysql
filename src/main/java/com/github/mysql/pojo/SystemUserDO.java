package com.github.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.mysql.pojo.common.GrantedAuthority;
import com.github.mysql.pojo.common.UserDetails;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static com.github.mysql.pojo.common.SystemAudit.CREATE_BY;
import static com.github.mysql.pojo.common.SystemAudit.CREATE_DATE;
import static com.github.mysql.pojo.common.SystemAudit.LAST_MODIFIED_BY;
import static com.github.mysql.pojo.common.SystemAudit.LAST_MODIFIED_DATE;
import static com.github.mysql.pojo.common.SystemField.ORG_ID;
import static com.github.mysql.pojo.common.SystemField.ROLE_ID;
import static com.github.mysql.pojo.common.SystemField.USER_ID;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_USER;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_USER_ROLE;

/**
 * <p>
 * 创建时间为 下午7:08 2019/9/17
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
@ToString(exclude = {"systemRoles", "systemOrg"})
@EqualsAndHashCode(exclude = {"systemRoles", "systemOrg"})
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = SYSTEM_USER)
@Where(clause = "deleted = false")
public class SystemUserDO implements UserDetails {

    private static final String FOREIGN_KEY_ORG_ID = "foreign_key_org_id";

    private static final long serialVersionUID = 6949655530047745714L;

    @Id
    @Column(name = USER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户名
     */
    @Column(columnDefinition = "COMMENT '用户名'")
    private String username;

    /**
     * 用户密码
     */
    @JsonIgnore
    @Column(columnDefinition = "COMMENT '用户密码'")
    private String password;

    @Column(name = FOREIGN_KEY_ORG_ID, insertable = false, updatable = false)
    private Long foreignKeyOrgId;

    /**
     * 用户备注
     */
    @Column(columnDefinition = "COMMENT '用户备注'")
    private String note;

    /**
     * 用户是否删除
     */
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '用户是否删除'")
    private Boolean deleted;

    /**
     * 用户过期时间
     */
    @Column(columnDefinition = "COMMENT '用户过期时间'")
    private Date accountExpireDate;

    /**
     * 用户没有过期
     */
    @JsonIgnore
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '用户没有过期'")
    private Boolean accountNonExpired;

    /**
     * 用户没被锁定
     */
    @JsonIgnore
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '用户没被锁定'")
    private Boolean accountNonLocked;

    /**
     * 用户凭证没有过期
     */
    @JsonIgnore
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '用户凭证没有过期'")
    private Boolean credentialsNonExpired;

    /**
     * 用户启用
     */
    @JsonIgnore
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '用户启用'")
    private Boolean enabled;

    @ManyToMany(targetEntity = SystemRoleDO.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = SYSTEM_USER_ROLE,
            joinColumns = {@JoinColumn(name = USER_ID, referencedColumnName = USER_ID)},
            inverseJoinColumns = {@JoinColumn(name = ROLE_ID, referencedColumnName = ROLE_ID)}
    )
    private Set<SystemRoleDO> systemRoles;

    @JsonIgnoreProperties(value = "systemUsers")
    @ManyToOne(targetEntity = SystemOrgDO.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = FOREIGN_KEY_ORG_ID, referencedColumnName = ORG_ID)
    private SystemOrgDO systemOrg;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return systemRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        if (null == accountNonExpired) {
            return true;
        }
        if (!accountNonExpired) {
            return false;
        }
        return System.currentTimeMillis() < accountExpireDate.getTime();
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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
