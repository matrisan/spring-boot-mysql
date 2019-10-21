package com.github.mysql.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>
 * 创建时间为 下午5:09 2019/9/20
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "table_shop")
@Entity(name = "entity_shop")
public class ShopDO {

    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品价格
     */
    private Integer price;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品信息
     */
    private String info;

    /**
     * 外键
     */
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreDO store;
}
