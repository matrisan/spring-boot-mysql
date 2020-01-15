package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * <p>
 * 创建时间为 17:34 2019-07-03
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
@Table(name = "table_datetime")
@Entity(name = "entity_datetime")
public class TemporalTypeDO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String note;

    /**
     * 只有日期
     * 2016-09-28
     */
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * 只有时间
     * 15:50:30
     */
    @Temporal(TemporalType.TIME)
    private Date time;

    /**
     * 日志+时间
     * 2016-09-28 15:52:32:000
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
}
