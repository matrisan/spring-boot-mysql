package com.github.mysql.service.impl;

import com.github.mysql.pojo.DepDO;
import com.github.mysql.repository.IDepRepository;
import com.github.mysql.service.IDepService;
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
public class DepServiceImpl implements IDepService {

    @Resource
    private IDepRepository repository;

    @Override
    public DepDO findById(long id) {
        Optional<DepDO> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Page<DepDO> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public DepDO save(DepDO depDO) {
        return repository.save(depDO);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
