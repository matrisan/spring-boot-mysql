package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
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


@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserIndexDO")
@Table(
        name = "UserIndexDO",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"role_name"}, name = "IDX_UNIQUE_NAME")},
        indexes = {@Index(columnList = "role",name = "IDX_NON_UNIQUE_ROLE")}
)
@EntityListeners(AuditingEntityListener.class)
public class UserIndexDO extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    private String role;

}


