package com.github.mysql.pojo;

import com.github.mysql.pojo.listener.UserStatusAuditListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
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
@Table(name = "table_user_customer")
@Entity(name = "entity_user_customer")
//@SequenceGenerator(name="SequenceGenerator_id_seq", initialValue=5000, allocationSize=5)
@EntityListeners({AuditingEntityListener.class, UserStatusAuditListener.class})
public class UserCustomerDO extends AbstractAuditAble implements Serializable {

    private static final long serialVersionUID = 7541529758557260700L;

    @Column(name = "name")
    private String name;

    @Column(columnDefinition = "int default 18", insertable = false)
    private Integer age;

    @Column(columnDefinition = "varchar(255) default 'man'")
    private String gender;


}
