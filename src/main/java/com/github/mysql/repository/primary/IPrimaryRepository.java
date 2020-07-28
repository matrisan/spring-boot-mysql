package com.github.mysql.repository.primary;

import com.github.mysql.pojo.orm.primary.PrimaryDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-07-28 09:35
 * @since 1.0
 */


public interface IPrimaryRepository extends JpaRepository<PrimaryDO, Long> {
}
