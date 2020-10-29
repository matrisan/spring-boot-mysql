package com.github.mysql.repository;


import com.github.mysql.pojo.orm.UserInfoDO;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * <p>
 * 创建时间为 15:54 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserInfoRepository extends JpaSpecificationExecutor<UserInfoDO>, JpaRepository<UserInfoDO, Long>, QuerydslPredicateExecutor<UserInfoDO> {

    UserInfoDO findByIdEquals(Long id);

    <V> Page<V> findAllBy(Predicate predicate, Pageable pageable, Class<V> clz);


}



