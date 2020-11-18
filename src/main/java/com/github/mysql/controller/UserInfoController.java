package com.github.mysql.controller;


import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.repository.IUserInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("users")
    public Page<UserInfoDO> findAll1(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }


}
