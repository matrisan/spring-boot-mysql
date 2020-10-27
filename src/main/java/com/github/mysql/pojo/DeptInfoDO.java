package com.github.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * 在互联网项目中，通常删除都不是物理删除，而是逻辑删除。
 * 那么在展示数据的时候需要过滤掉已删除的数据。
 * 而@Where 注解可以说就是为此而设计的。
 * Entity 实体类的名称, 全局唯一,
 *
 * <p>
 * 创建时间为 15:53 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Slf4j
@Builder
@ToString(exclude = "empInfos")
@EqualsAndHashCode(exclude = "empInfos")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_dept")
@Entity
@Where(clause = "deleted = false")
@DynamicInsert
@DynamicUpdate
public class DeptInfoDO implements Serializable {

    private static final long serialVersionUID = -3509680463086200457L;

    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    private String name;

    @JsonIgnoreProperties("deptInfo")
    @OneToMany(mappedBy = "deptInfo", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @OrderBy("age desc")
    public Set<EmpInfoDO> empInfos;

    @JsonIgnore
    @Column(name = "deleted", columnDefinition = "INT(11) default 0 comment '是否删除'")
    private Boolean deleted;
}
