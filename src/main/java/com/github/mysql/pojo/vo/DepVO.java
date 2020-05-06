package com.github.mysql.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.mysql.pojo.table.EmpDO;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@ToString(exclude = "emps")
@EqualsAndHashCode(exclude = "emps")
@NoArgsConstructor
@AllArgsConstructor
public class DepVO   {


    private Long depId;

    private String depName;

    @OrderBy("empId asc")
    private Set<EmpVO> emps;

}
