package com.github.mysql.pojo;

import com.github.mysql.listener.UserEntityListener;
import com.google.common.collect.Lists;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

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
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}, name = "IDX_UNIQUE_NAME")},
        indexes = {@Index(columnList = "role", name = "IDX_NON_UNIQUE_ROLE")}
)
@DynamicInsert
@DynamicUpdate
@EntityListeners(UserEntityListener.class)
public class UserInfoDO extends BaseEntity {

    @Column(name = "username", nullable = false, columnDefinition = "varchar(100) default '默认名字' comment '我是username注释'")
    private String username;

    @Column(name = "age", nullable = false, columnDefinition = "INT(11) default 18 comment '我是age注释'")
    private Integer age;

    private String role;

    @DomainEvents
    public List<UserInfoDO> domainEvents() {
        return Lists.newArrayList(this);
    }

    @AfterDomainEventPublication
    public void callbackMethod() {
        System.out.println("CallBackMethod");
    }

}


