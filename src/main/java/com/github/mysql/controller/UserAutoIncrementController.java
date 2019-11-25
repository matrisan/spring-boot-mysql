package com.github.mysql.controller;

import com.github.mysql.pojo.UserAutoIncrementDO;
import com.github.mysql.repository.IUserAutoIncrementRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午4:47 2019/11/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserAutoIncrementController {

    @Resource
    private IUserAutoIncrementRepository repository;

    @GetMapping("/auto_increment/{id}")
    public UserAutoIncrementDO getById(@PathVariable("id") UserAutoIncrementDO userAutoIncrementDO) {
        return userAutoIncrementDO;
    }

    @PostMapping("/auto_increment")
    public UserAutoIncrementDO getUserAutoIncrement(@RequestBody UserAutoIncrementDO userAutoIncrementDO) {
        return repository.save(userAutoIncrementDO);
    }

}
