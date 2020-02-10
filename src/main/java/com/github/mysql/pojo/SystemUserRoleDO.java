package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
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
@IdClass(SystemUserRoleDO.UserRoleKey.class)
@EntityListeners({AuditingEntityListener.class})
public class SystemUserRoleDO implements Serializable {

    private static final long serialVersionUID = 5412700478036446014L;

//    @Id
//    @Column(name = "mid_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long midId;

    @Id
    @Column(name = "mid_user_id")
    private Long midUserId;

    @Id
    @Column(name = "mid_role_id")
    private Long midRoleId;

//    @ManyToOne(targetEntity = ManyToManyUserDO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "mid_user_id", referencedColumnName = "user_id")
//    private ManyToManyUserDO manyUser;
//
//    @ManyToOne(targetEntity = ManyToManyRoleDO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "mid_role_id", referencedColumnName = "role_id")
//    private ManyToManyRoleDO manyRole;

    @CreatedDate
    @Column(name = "create_date")
    private Date createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class UserRoleKey implements Serializable {

        private static final long serialVersionUID = -5555780080241657369L;

        @Column(name = "mid_user_id")
        private Long midUserId;

        @Column(name = "mid_role_id")
        private Long midRoleId;

    }

}


