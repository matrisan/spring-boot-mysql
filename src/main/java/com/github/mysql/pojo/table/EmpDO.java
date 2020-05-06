package com.github.mysql.pojo.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

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
@ToString(exclude = "dep")
@EqualsAndHashCode(exclude = "dep")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_emp")
@Entity
public class EmpDO implements Serializable {

    private static final long serialVersionUID = -1491389679180230248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    private String empName;

    @Column(name = "foreign_key_dept_id", insertable = false, updatable = false)
    private Long foreignKeyDeptId;

    @ManyToOne(targetEntity = DepDO.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "foreign_key_dept_id", referencedColumnName = "dep_id")
    @JsonIgnoreProperties(value = {"emps"})
    @JsonIgnore
    private DepDO dep;

}
