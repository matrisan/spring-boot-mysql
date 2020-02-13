package com.github.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>
 * 创建时间为 下午9:22 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
@Builder
@ToString(exclude = "order")
@EqualsAndHashCode(exclude = "order")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SystemItem")
@Entity
public class SystemItem {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;


    private String itemName;


    @Column(name = "i_order_id", insertable = false, updatable = false)
    private Long iOrderId;

    @JsonIgnoreProperties(value = "order")
    @ManyToOne(targetEntity = SystemOrder.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "i_order_id", referencedColumnName = "order_id")
    private SystemOrder order;

}
