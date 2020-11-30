package com.github.mysql.controller;


import com.github.mysql.pojo.bo.AddressBO;
import com.github.mysql.repository.IUserInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class UserInfoController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("username/{name}")
    public AddressBO username(@PathVariable String name) {
        return repository.username(name);
    }

    @GetMapping("address/{name1}/{name2}")
    public int address(@PathVariable String name1, @PathVariable String name2) {
        return repository.replace(name1, name2);
    }

}
