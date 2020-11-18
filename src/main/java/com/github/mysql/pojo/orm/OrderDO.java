package com.github.mysql.pojo.orm;

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

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.List;

/**
 * @author 石少东
 * @date 2020-11-18 23:37
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
@Table(name = "OrderDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
public class OrderDO extends BaseEntity {

    private static final long serialVersionUID = -1492594453375055564L;

    private String orderName;

    @ElementCollection
    private List<ItemDO> items;


}
