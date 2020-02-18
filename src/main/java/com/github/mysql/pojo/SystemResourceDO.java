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
import static com.github.mysql.pojo.common.SystemField.RESOURCE_ID;
import static com.github.mysql.pojo.common.SystemTableName.SYSTEM_RESOURCE;

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
@ToString(exclude = {"systemRoles"})
@EqualsAndHashCode(exclude = {"systemRoles"})
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = SYSTEM_RESOURCE)
@Where(clause = "deleted = false")
public class SystemResourceDO implements Serializable {

    private static final String PARENT_RES_ID = "parent_resource_id";

    private static final long serialVersionUID = 7162673841544704638L;

    @Id
    @Column(name = RESOURCE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    /**
     * 字段名称
     */
    @Column(name = "resource_name",columnDefinition = "INT(11) DEFAULT 0 COMMENT '字段名称'")
    private String resourceName;

    /**
     * 资源的URL
     */
    @Column(columnDefinition = "COMMENT '资源的URL'")
    private String url;

    /**
     * 资源的图标
     */
    @Column(columnDefinition = "COMMENT '资源的图标'")
    private String icon;

    /**
     * 资源说明
     */
    @Column(columnDefinition = "COMMENT '资源说明'")
    private String note;

    /**
     * 父节点 ID
     */
    @Column(name = PARENT_RES_ID, insertable = false, updatable = false, columnDefinition = "COMMENT '父节点的ID'")
    private Long parentResId;

    /**
     * 是否删除
     */
    @Column(columnDefinition = "COMMENT '是否删除'")
    private Boolean deleted;


    @ManyToMany(mappedBy = "systemRess")
    private Set<SystemRoleDO> systemRoles;

    @JsonIgnoreProperties(value = "parentRes")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parentRes")
    private Set<SystemResourceDO> childRess;

    @JsonIgnoreProperties(value = "childRess")
    @ManyToOne(targetEntity = SystemResourceDO.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = PARENT_RES_ID, referencedColumnName = RESOURCE_ID)
    private SystemResourceDO parentRes;

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
