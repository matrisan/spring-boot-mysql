package com.github.mysql.controller;

import com.github.mysql.pojo.UserIndexDO;
import com.github.mysql.repository.IUserIndexRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午4:08 2019/11/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserIndexController {

    @Resource
    private IUserIndexRepository repository;

    @GetMapping("user")
    public List<UserIndexDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("user")
    public UserIndexDO findAll(@RequestBody UserIndexDO userIndex) {
        return repository.save(userIndex);
    }

}
