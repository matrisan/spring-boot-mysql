package com.github.mysql.pojo.orm;

import com.github.mysql.pojo.BaseEntity;
import com.github.mysql.pojo.vo.UserInfoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Index;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * 创建时间为 下午10:01 2019/11/26
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@SqlResultSetMappings({
        @SqlResultSetMapping(name = "user", entities = {@EntityResult(entityClass = UserInfoVO.class)})
})
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "UserInfoDO",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "IDX_UNIQUE_NAME")},
        indexes = {@Index(columnList = "role", name = "IDX_NON_UNIQUE_ROLE")}
)
@DynamicInsert
@DynamicUpdate
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = 460626250371942731L;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default '默认名字' comment '我是username注释'")
    private String username;

    @Column(name = "age", nullable = false, columnDefinition = "INT(11) default 18 comment '我是age注释'")
    private Integer age;

    private String role;

}


