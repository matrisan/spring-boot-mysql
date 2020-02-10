package com.github.mysql.controller;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.pojo.SystemUserRoleDO;
import com.github.mysql.repository.ISystemRoleRepository;
import com.github.mysql.repository.ISystemUserRoleRepository;
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
 * 创建时间为 下午2:18 2020/2/10
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserRoleController {

    @Resource
    private ISystemUserRoleRepository repository;

    @GetMapping("user_role")
    public List<SystemUserRoleDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("user_role")
    public SystemUserRoleDO save(@RequestBody SystemUserRoleDO userRole) {
        return repository.save(userRole);
    }

    @PutMapping("user_role")
    public SystemUserRoleDO update(@RequestBody SystemUserRoleDO userRole) {
        return repository.save(userRole);
    }

    @DeleteMapping("user_role")
    public SystemUserRoleDO delete(@RequestBody SystemUserRoleDO userRole) {
        return repository.save(userRole);
    }



}
