package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
import java.util.Date;

import static com.github.mysql.pojo.SystemCommon.SYSTEM_USER_ROLE;

/**
 * <p>
 * 创建时间为 下午10:49 2020/2/5
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = SYSTEM_USER_ROLE)
@EntityListeners(AuditingEntityListener.class)
public class SystemUserRoleDO {

    @Id
    @Column(name = "mid_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long midId;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private ManyToManyUserDO manyUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.REFRESH)
    @JoinColumn(name = "role_id")
    private ManyToManyRoleDO manyRole;

    @CreatedDate
    @Column(name = "create_date")
    private Date createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

}
