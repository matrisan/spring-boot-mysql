package com.github.mysql.controller;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.repository.ISystemRoleRepository;
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
public class RoleController {

    @Resource
    private ISystemRoleRepository repository;

    @GetMapping("role")
    public List<ManyToManyRoleDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("role")
    public ManyToManyRoleDO save(@RequestBody ManyToManyRoleDO manyRole) {
        return repository.save(manyRole);
    }

    @PutMapping("role")
    public ManyToManyRoleDO update(@RequestBody ManyToManyRoleDO manyRole) {
        return repository.save(manyRole);
    }

    @DeleteMapping("role")
    public ManyToManyRoleDO delete(@RequestBody ManyToManyRoleDO manyRole) {
        return repository.save(manyRole);
    }

}
