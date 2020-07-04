package com.github.mysql.pojo.orm.company;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;

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
@Table(name = "DepartmentDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
public class DepartmentDO extends BaseEntity {

    private String depName;

    @JsonManagedReference
    @MapKey(name = "empName")
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "department")
    private Map<String, EmployeeDO> employees;

}
