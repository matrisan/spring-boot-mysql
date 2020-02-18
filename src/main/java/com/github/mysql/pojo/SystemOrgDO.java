package com.github.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static com.github.mysql.pojo.common.SystemAudit.CREATE_BY;
import static com.github.mysql.pojo.common.SystemAudit.CREATE_DATE;
import static com.github.mysql.pojo.common.SystemAudit.LAST_MODIFIED_BY;
import static com.github.mysql.pojo.common.SystemAudit.LAST_MODIFIED_DATE;
import static com.github.mysql.pojo.common.SystemField.MID_ORG_ID;
import static com.github.mysql.pojo.common.SystemField.MID_ROLE_ID;
import static com.github.mysql.pojo.common.SystemField.ORG_ID;
import static com.github.mysql.pojo.common.SystemField.ROLE_ID;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_ORG;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_ORG_ROLE;


/**
 * <p>
 * 创建时间为 上午10:53 2020/2/5
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
@ToString(exclude = {"systemRoles", "systemUsers", "parentOrg", "childOrgs"})
@EqualsAndHashCode(exclude = {"systemRoles", "systemUsers", "parentOrg", "childOrgs"})
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = SYSTEM_ORG)
@Where(clause = "deleted = false")
public class SystemOrgDO implements Serializable {

    private static final String FOREIGN_KEY_PARENT_ORG_ID = "foreign_key_parent_org_id";

    private static final long serialVersionUID = -4959747021336438256L;

    @Id
    @Column(name = ORG_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgId;

    /**
     * 组织名称
     */
    @Column(name = "org_name", columnDefinition = "COMMENT '组织名称'")
    private String orgName;

    /**
     * 组织图标
     */
    @Column(columnDefinition = "COMMENT '组织图标'")
    private String icon;

    /**
     * 备注
     */
    @Column(columnDefinition = "COMMENT '备注'")
    private String note;

    /**
     * 父节点的 ID
     */
    @Column(name = FOREIGN_KEY_PARENT_ORG_ID, columnDefinition = "COMMENT '父节点ID'", insertable = false, updatable = false)
    private Long foreignKeyParentOrgId;

    /**
     * 是否删除
     */
    @Column(columnDefinition = "INT(11) DEFAULT 0 COMMENT '是否删除'")
    private Boolean deleted;

    /**
     * 本 节点 所能查询到的所有的角色
     */
    @ManyToMany(
            targetEntity = SystemRoleDO.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = SYSTEM_ORG_ROLE,
            joinColumns = {@JoinColumn(name = MID_ORG_ID, referencedColumnName = ORG_ID)},
            inverseJoinColumns = {@JoinColumn(name = MID_ROLE_ID, referencedColumnName = ROLE_ID)}
    )
    private Set<SystemRoleDO> systemRoles;

    /**
     * 本 节点 所拥有的所有的用户
     */
    @JsonIgnoreProperties(value = "systemOrg")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "systemOrg")
    private Set<SystemUserDO> systemUsers;

    /**
     * 本 节点 下面的所有的 子节点
     */
    @JsonIgnoreProperties(value = "parentOrg")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parentOrg")
    private Set<SystemOrgDO> childOrgs;

    /**
     * 本 节点 的 父节点
     */
    @JsonIgnoreProperties(value = "childOrgs")
    @ManyToOne(targetEntity = SystemOrgDO.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = FOREIGN_KEY_PARENT_ORG_ID, referencedColumnName = ORG_ID)
    private SystemOrgDO parentOrg;

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
