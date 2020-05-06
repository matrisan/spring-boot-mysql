package com.github.mysql.pojo.vo;

import com.github.mysql.pojo.table.DepDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

public class EmpVO {

    private Long empId;

    private String empName;

    private DepVO dep;
}
