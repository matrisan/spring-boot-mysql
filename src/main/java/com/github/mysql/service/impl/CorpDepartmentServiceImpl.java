package com.github.mysql.service.impl;

import com.github.mysql.pojo.OneToManyDepartmentDO;
import com.github.mysql.repository.ICorpDepartmentRepository;
import com.github.mysql.service.ICorpDepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 下午9:04 2019/10/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CorpDepartmentServiceImpl implements ICorpDepartmentService {

    @Resource
    private ICorpDepartmentRepository repository;

    @Override
    public OneToManyDepartmentDO findById(long id) {
        Optional<OneToManyDepartmentDO> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Page<OneToManyDepartmentDO> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public OneToManyDepartmentDO save(OneToManyDepartmentDO oneToManyDepartmentDO) {
        return repository.save(oneToManyDepartmentDO);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
