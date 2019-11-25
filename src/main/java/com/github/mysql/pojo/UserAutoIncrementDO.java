package com.github.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午10:52 2019/11/5
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserAutoIncrementDO")
@Entity
//@SequenceGenerator(name = "SequenceGenerator_id_seq", initialValue = 5000, allocationSize = 5)
public class UserAutoIncrementDO implements Serializable {

    private static final long serialVersionUID = 5166725952903400603L;


    @Id
    @TableGenerator(
            name = "AppSeqStore",
            table = "APP_SEQ_STORE",
            pkColumnName = "APP_SEQ_NAME",
            pkColumnValue = "LISTENER_PK",
            valueColumnName = "APP_SEQ_VALUE",
            initialValue = 10000,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AppSeqStore")
    @Column(name = "id")
    private Long id;

    private String name;

    @Column(columnDefinition = "int default 18")
    private Integer age;

    @Column(columnDefinition = "varchar(255) default 'man'")
    private String gender;
}
