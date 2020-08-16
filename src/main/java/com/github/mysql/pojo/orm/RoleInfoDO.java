package com.github.mysql.pojo.orm;

import com.github.mysql.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Objects;

import static com.github.mysql.pojo.constant.TableName.ROLE_INFO;

/**
 * @author 石少东
 * @date 2020-06-04 19:52
 */


@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ROLE_INFO)
@DynamicInsert
@DynamicUpdate
public class RoleInfoDO extends BaseEntity {

    private static final long serialVersionUID = 8068910483842716910L;

    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleInfoDO that = (RoleInfoDO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
