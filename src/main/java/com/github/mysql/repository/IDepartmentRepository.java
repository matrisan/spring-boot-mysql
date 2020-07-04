package com.github.mysql.repository;

import com.github.mysql.pojo.orm.company.DepartmentDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-07-04 18:45
 * @since 1.0
 */


public interface IDepartmentRepository extends JpaRepository<DepartmentDO, Long> {
}
