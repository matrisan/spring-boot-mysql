package com.github.mysql.pojo.orm.mid;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 石少东
 * @date 2020-08-06 23:25
 * @since 1.0
 */


@Getter
@Setter
public class UserRolePk implements Serializable {

    private static final long serialVersionUID = 1885655943868131843L;

//    @Column(name = "mid_user_id")
    private Long midUserId;

//    @Column(name = "mid_role_id")
    private Long midRoleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserRolePk that = (UserRolePk) o;
        return Objects.equals(midUserId, that.midUserId) &&
                Objects.equals(midRoleId, that.midRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(midUserId, midRoleId);
    }
}
