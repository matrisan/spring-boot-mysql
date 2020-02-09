package com.github.mysql.ainit;

import com.github.mysql.pojo.OneToOneParentInfoDO;
import com.github.mysql.repository.IParentInfoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午11:13 2019/9/19
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
//@Component
public class InitPerson {

    @Resource
    private IParentInfoRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        for (int i = 0; i < 8; i++) {
            OneToOneParentInfoDO oneToOneParentInfoDO = new OneToOneParentInfoDO();
            oneToOneParentInfoDO.setId(i);
            oneToOneParentInfoDO.setUsername("name:" + i);
            oneToOneParentInfoDO.setAge(10);
            repository.save(oneToOneParentInfoDO);
        }
    }

}
