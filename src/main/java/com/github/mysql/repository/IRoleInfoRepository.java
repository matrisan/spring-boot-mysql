package com.github.mysql.repository;

import com.github.mysql.pojo.orm.RoleInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午8:44 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IRoleInfoRepository extends JpaRepository<RoleInfoDO, Long> {
    /**
     * 分页查询所有的UserInfoDO，并将字段投影到泛型 T 的字段上
     *
     * @param pageable 分页信息
     * @param clz      泛型类型
     * @param <T>      泛型
     * @return Page
     */
    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

}
