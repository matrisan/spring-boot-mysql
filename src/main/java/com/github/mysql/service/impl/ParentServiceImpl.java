package com.github.mysql.service.impl;

import com.github.mysql.pojo.OneToOneParentInfoDO;
import com.github.mysql.repository.IParentInfoRepository;
import com.github.mysql.service.IParentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午12:57 2019/10/9
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class ParentServiceImpl implements IParentService {

    @Resource
    private IParentInfoRepository repository;

    @Override
    public OneToOneParentInfoDO savePerson(OneToOneParentInfoDO oneToOneParentInfoDO) {
        return repository.save(oneToOneParentInfoDO);
    }

    @Override
//    @Transactional
    public OneToOneParentInfoDO updatePerson(@NotNull OneToOneParentInfoDO oneToOneParentInfoDO) {
        if (repository.existsById(oneToOneParentInfoDO.getId())) {
            repository.deleteById(oneToOneParentInfoDO.getId());
        }else {
            throw new RuntimeException();
        }
        return repository.save(oneToOneParentInfoDO);
    }
}
