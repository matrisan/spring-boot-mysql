package com.github.mysql.pojo.orm.company;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.mysql.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 石少东
 * @date 2020-07-04 18:33
 * @since 1.0
 */

@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "EmployeeDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
public class EmployeeDO extends BaseEntity {

    @Column(unique = true)
    private String empName;

    @Column(name = "foreign_key_dept_id", insertable = false, updatable = false)
    private Long foreignKeyDeptId;

    @JsonBackReference
    @ManyToOne(targetEntity = DepartmentDO.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "foreign_key_dept_id", referencedColumnName = "id")
    private DepartmentDO department;

}
