package com.github.mysql.pojo;

import com.github.mysql.pojo.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 石少东
 * @date 2020-10-27 14:46
 * @since 1.0
 */

@Getter
@Setter
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Where(clause = "deleted = false or deleted is null")
@EqualsAndHashCode(of = "id", callSuper = false)
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = 2473834958118360950L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户名'")
    private String username;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '手机号码'")
    private String mobile;

    private Integer age;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    private String email;

}
