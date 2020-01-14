package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_userinfo")
@Entity(name = "entity_userinfo")
@EntityListeners(AuditingEntityListener.class)
public class UserInfoDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    /**
     * 当这个对象被保存时会调用这个方法，这个方法会发布信息被
     * {@link com.github.mysql.event.handler.UserInfoSaveEventHandler#event} 方法接收到
     *
     * @return Collection
     */
    @DomainEvents
    public Collection<UserInfoDO> domainEvents() {
        log.info("----------UserInfoDO----------domainEvents");
        return Collections.singletonList(this);
    }

    /**
     * 在发布事件完成后调用
     */
    @AfterDomainEventPublication
    public void callbackMethod() {
        log.info("----------callbackMethod");
    }

}
