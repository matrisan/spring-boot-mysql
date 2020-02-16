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
import org.hibernate.annotations.Where;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午8:29 2020/2/14
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
@ToString(exclude = "deptInfo")
@EqualsAndHashCode(exclude = "deptInfo")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_emp")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted = false")
public class EmpInfoDO implements Serializable {

    private static final long serialVersionUID = 7680830897352997922L;

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String name;

    private Integer age;

    @Column(name = "foreign_dept_id", insertable = false, updatable = false)
    private Long foreignDeptId;

    @JsonIgnoreProperties(value = "empInfos")
    @ManyToOne(targetEntity = DeptInfoDO.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "foreign_dept_id", referencedColumnName = "dept_id")
    public DeptInfoDO deptInfo;

    @JsonIgnore
    private Boolean deleted;
}
