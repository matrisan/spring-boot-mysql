package com.github.mysql.controller;

import com.github.mysql.pojo.PersonInfoDO;
import com.github.mysql.repository.IPersonInfoDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 21:38 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class PersonInfoDoController {

    @Resource
    private IPersonInfoDoRepository repository;

    @GetMapping("/person/{id}")
    public PersonInfoDO getById(@PathVariable("id") PersonInfoDO personInfoDO) {
        return personInfoDO;
    }

    @PostMapping("/person")
    public PersonInfoDO save(@RequestBody PersonInfoDO personInfoDO) {
        return repository.save(personInfoDO);
    }

}
