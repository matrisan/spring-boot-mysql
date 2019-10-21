package com.github.mysql.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午5:11 2019/9/20
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
@Table(name = "table_store")
@Entity(name = "entity_store")
public class StoreDO {

    /**
     * 商铺号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商铺姓名
     */
    private String name;

    /**
     * 商铺地址
     */
    private String address;

    /**
     * 商铺联系
     */
    private Integer tel;

    /**
     * 商铺信息
     */
    private String info;


    @Singular
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private Set<ShopDO> shops;

}