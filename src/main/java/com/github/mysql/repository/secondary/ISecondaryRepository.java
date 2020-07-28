package com.github.mysql.repository.secondary;


import com.github.mysql.pojo.orm.secondary.SecondaryDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-07-28 09:35
 * @since 1.0
 */


public interface ISecondaryRepository extends JpaRepository<SecondaryDO, Long> {
}
