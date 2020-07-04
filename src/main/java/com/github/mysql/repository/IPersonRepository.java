package com.github.mysql.repository;

import com.github.mysql.pojo.orm.person.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-07-04 19:29
 * @since 1.0
 */


public interface IPersonRepository extends JpaRepository<PersonDO, Long> {
}
