package com.github.mysql.pojo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import java.util.Date;

/**
 * <p>
 * 创建时间为 下午10:47 2019/11/5
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditAble {

    @Id
    @TableGenerator(initialValue = 10000, name = "TableGeneratorName")
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

}
