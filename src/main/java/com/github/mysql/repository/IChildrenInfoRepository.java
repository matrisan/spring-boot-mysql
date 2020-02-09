package com.github.mysql.repository;


import com.github.mysql.pojo.OneToOneChildrenInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 21:37 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IChildrenInfoRepository extends JpaRepository<OneToOneChildrenInfoDO, Integer> {

}
