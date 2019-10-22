package com.github.mysql.service.impl;

import com.github.mysql.pojo.PersonInfoDO;
import com.github.mysql.repository.IPersonInfoRepository;
import com.github.mysql.service.IPersonService;
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
public class PersonServiceImpl implements IPersonService {

    @Resource
    private IPersonInfoRepository repository;

    @Override
    public PersonInfoDO savePerson(PersonInfoDO personInfoDO) {
        return repository.save(personInfoDO);
    }

    @Override
//    @Transactional
    public PersonInfoDO updatePerson(@NotNull PersonInfoDO personInfoDO) {
        if (repository.existsById(personInfoDO.getId())) {
            repository.deleteById(personInfoDO.getId());
        }else {
            throw new RuntimeException();
        }
        return repository.save(personInfoDO);
    }
}
