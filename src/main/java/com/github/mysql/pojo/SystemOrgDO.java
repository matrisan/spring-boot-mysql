package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 创建时间为 上午10:52 2020/2/17
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString(exclude = {"systemOrg"})
@EqualsAndHashCode(exclude = {"systemOrg"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "system_org")
public class SystemOrgDO implements Serializable {

    private static final long serialVersionUID = 4919377510519260083L;

    @Id
    @Column(name = "org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgId;

    private String name;

    @Column(name = "p_org_id")
    private Long pOrgId;

    /**
     * name = "addressId" 指定了上面 String addressId, 映射到 AddressDO 的 id 字段.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "p_org_id", referencedColumnName = "org_id", insertable = false, updatable = false)
    private SystemOrgDO systemOrg;

}
