package com.github.mysql.repository;

import com.github.mysql.pojo.orm.GroupInfoDO;
import com.github.mysql.pojo.orm.mid.MidUserRoleDO;
import com.github.mysql.pojo.orm.mid.UserRolePk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-08-06 23:14
 * @since 1.0
 */


public interface IMidUserRoleRepository extends JpaRepository<MidUserRoleDO, UserRolePk> {


}
