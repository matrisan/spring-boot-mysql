package com.github.mysql.service;

import com.github.mysql.pojo.CorpDepartmentDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 下午9:02 2019/10/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICorpDepartmentService {

    CorpDepartmentDO findById(long id);

    Page<CorpDepartmentDO> findAll(Pageable pageable);

    CorpDepartmentDO save(CorpDepartmentDO corpDepartmentDO);


    void deleteById(Long id);
}
