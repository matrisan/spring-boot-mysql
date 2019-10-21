package com.github.mysql.pojo;

import com.github.mysql.event.EventUserSave;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.Contract;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Entity 实体类的名称, 全局唯一,
 *
 * <p>
 * 创建时间为 15:53 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_userinfo")
@Entity(name = "entity_userinfo")
@EntityListeners(AuditingEntityListener.class)
public class UserInfoDO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    /**
     * 枚举类映射为 String
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender gender;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    public enum Gender {

        /**
         * 男
         */
        MAIL("男"),

        /**
         * 女
         */
        FMAIL("女");

        private String value;

        @Contract(pure = true)
        Gender(String value) {
            this.value = value;
        }

    }

    @DomainEvents
    public Collection<EventUserSave> domainEvents() {
        return Collections.singletonList(new EventUserSave(this.id, this.username));
    }

    @AfterDomainEventPublication
    void callbackMethod() {
        //
    }

}
