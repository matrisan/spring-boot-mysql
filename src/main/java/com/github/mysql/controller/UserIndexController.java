package com.github.mysql.controller;


import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.pojo.vo.UserInfoVO;
import com.github.mysql.repository.IUserInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private IUserInfoRepository repository;

    @GetMapping("user")
    public List<UserInfoDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("user/roles")
    public Page<String> findAllRoles(@PageableDefault(size = 4, direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findAllRoles(pageable);
    }


    @GetMapping("user/id/{userId}")
    public UserInfoDO getByUserId(@PathVariable("userId") UserInfoDO userInfoDO) {
        return userInfoDO;
    }

    @PostMapping("user")
    public UserInfoDO findAll(@RequestBody UserInfoDO userIndex) {
        return repository.save(userIndex);
    }

    @GetMapping("/user/username/{username}")
    public UserInfoVO getByUsername(@PathVariable String username) {
        return repository.findByUsername(username);
    }

}
