package com.github.mysql.controller;

import com.github.mysql.pojo.RoleInfoDO;
import com.github.mysql.repository.IRoleInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:43 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class RoleInfoController {

    @Resource
    private IRoleInfoRepository repository;

    @GetMapping("role")
    public List<RoleInfoDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("role")
    public RoleInfoDO save(@RequestBody RoleInfoDO roleInfo) {
        return repository.save(roleInfo);
    }

}
