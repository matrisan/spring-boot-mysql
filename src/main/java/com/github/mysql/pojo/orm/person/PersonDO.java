package com.github.mysql.pojo.orm.person;

import com.github.mysql.pojo.BaseEntity;
import com.github.mysql.pojo.converter.MapConverter;
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

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-07-04 19:25
 * @since 1.0
 */

@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "users", callSuper = false)
@Entity
@Table(name = "PersonDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners({AuditingEntityListener.class})
@SuppressWarnings("all")
public class PersonDO extends BaseEntity {

    @Convert(converter = MapConverter.class)
    private Map<String, AddressBO> address;

}
