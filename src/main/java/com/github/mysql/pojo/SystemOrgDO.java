package com.github.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午12:30 2020/2/17
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
@Builder
@ToString(exclude = {"systemOrgs", "systemOrg"})
@EqualsAndHashCode(exclude = {"systemOrgs", "systemOrg"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_org")
@Entity
public class SystemOrgDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Long orgId;


    private String name;



    @Column(name = "p_org_id", insertable = false, updatable = false)
    private Long pOrgId;

    @JsonIgnoreProperties(value = "systemOrg")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "systemOrg")
    private Set<SystemOrgDO> systemOrgs;


    @JsonIgnoreProperties(value = "systemOrgs")
    @ManyToOne(targetEntity = SystemOrgDO.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_org_id", referencedColumnName = "org_id")
    private SystemOrgDO systemOrg;

}
