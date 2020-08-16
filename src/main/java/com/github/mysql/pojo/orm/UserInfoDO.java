package com.github.mysql.pojo.orm;

import com.github.mysql.pojo.BaseEntity;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.Objects;

import static com.github.mysql.pojo.constant.TableName.USER_INFO;

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
        name = USER_INFO,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}, name = "IDX_UNIQUE_NAME")},
        indexes = {@Index(columnList = "role", name = "IDX_NON_UNIQUE_ROLE")}
)
@DynamicInsert
@DynamicUpdate
public class UserInfoDO extends BaseEntity {

    private static final long serialVersionUID = -7565947168915682933L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfoDO that = (UserInfoDO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


