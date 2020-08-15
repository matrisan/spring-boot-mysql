package com.github.mysql.controller;

import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-06-22 16:51
 * @since 1.0
 */


@RestController
public class UserInfoController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("/user/{username}/{age}")
    public UserInfoDO updateAge(@PathVariable String username, @PathVariable Integer age) {
        repository.updateAgeByUsername(username, age);
        return null;
    }

    @PostMapping("/user")
    public UserInfoDO save(@RequestBody UserInfoDO userInfo) {
        return repository.save(userInfo);
    }


}
