package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;


/**
 * <p>
 * 创建时间为 下午4:16 2019/9/12
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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_department")
@Entity(name = "entity_department")
public class OneToManyDepartmentDO implements Serializable {

    private static final long serialVersionUID = 6642907291335085530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    private String dName;

    @OneToMany(targetEntity = OneToManyEmployeeDO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id", referencedColumnName = "department_id")
    private Set<OneToManyEmployeeDO> employees;

}
