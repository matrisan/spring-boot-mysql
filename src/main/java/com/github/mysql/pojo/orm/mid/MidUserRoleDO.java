package com.github.mysql.pojo.orm.mid;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.mysql.pojo.BaseEntity;
import com.github.mysql.pojo.orm.RoleInfoDO;
import com.github.mysql.pojo.orm.UserInfoDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 石少东
 * @date 2020-08-05 22:26
 * @since 1.0
 */

@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@IdClass(UserRolePk.class)
@Table(name = "system_user_role")
public class MidUserRoleDO extends BaseEntity {

    private static final long serialVersionUID = 8192624846189463869L;

    @Id
    @Column(name = "mid_user_id", insertable = false, updatable = false)
    private Long midUserId;

    @Id
    @Column(name = "mid_role_id", insertable = false, updatable = false)
    private Long midRoleId;

    @ManyToOne(targetEntity = UserInfoDO.class, cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "mid_user_id", referencedColumnName = "id")
    @JsonManagedReference
    private UserInfoDO user;

    @ManyToOne(targetEntity = RoleInfoDO.class, cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "mid_role_id", referencedColumnName = "id")
    @JsonManagedReference
    private RoleInfoDO role;

}

