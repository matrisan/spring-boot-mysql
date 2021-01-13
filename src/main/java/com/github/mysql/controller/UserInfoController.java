package com.github.mysql.controller;


import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.pojo.vo.UserInfoVO;
import com.github.mysql.repository.IUserInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

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
    public Page<UserInfoVO> findAll(@PageableDefault Pageable pageable) {
        return repository.findAllBy(pageable, UserInfoVO.class);
    }

    @GetMapping("user/u/{name}")
    public UserInfoVO findByUsername(@PathVariable String name) {
        return repository.findByUsername(name, UserInfoVO.class);
    }

    @GetMapping("user/roles")
    public Page<String> findAllRoles(@PageableDefault(size = 4, direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findAllRoles(pageable);
    }

    @GetMapping("user/id/{userId}")
    public UserInfoDO getByUserId(@PathVariable("userId") Optional<UserInfoDO> optional) {
        return optional.orElse(null);
    }

    @PostMapping("user")
    public UserInfoDO save(@RequestBody UserInfoDO userIndex) {
        return repository.save(userIndex);
    }


    @PatchMapping("user/{userId}/{username}")
    public UserInfoDO patch(@PathVariable("userId") UserInfoDO userInfoDO, @PathVariable String username) {
        userInfoDO.setUsername(username);
        return repository.save(userInfoDO);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return "success";
    }

}
