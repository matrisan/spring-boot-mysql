package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author 石少东
 * @date 2020-06-04 19:52
 */


@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RoleInfoDO")
@DynamicInsert
@DynamicUpdate
public class RoleInfoDO extends BaseEntity {

    private String roleName;

}
