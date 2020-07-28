package com.github.mysql.pojo.orm.primary;

import com.github.mysql.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author 石少东
 * @date 2020-07-27 19:32
 * @since 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PrimaryDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
public class PrimaryDO extends BaseEntity {

    private String name;

}
