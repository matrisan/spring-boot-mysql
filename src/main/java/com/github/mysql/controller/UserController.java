package com.github.mysql.controller;

import com.github.mysql.pojo.ManyToManyUserDO;
import com.github.mysql.repository.ISystemUserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午9:19 2020/2/9
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserController {

    @Resource
    private ISystemUserRepository repository;

    @GetMapping("user")
    public List<ManyToManyUserDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("user")
    public ManyToManyUserDO save(@RequestBody ManyToManyUserDO manyUser) {
        return repository.save(manyUser);
    }

    @PutMapping("user")
    public ManyToManyUserDO update(@RequestBody ManyToManyUserDO manyUser) {
        return repository.save(manyUser);
    }

    @DeleteMapping("user")
    public ManyToManyUserDO delete(@RequestBody ManyToManyUserDO manyUser) {
        return repository.save(manyUser);
    }

}
