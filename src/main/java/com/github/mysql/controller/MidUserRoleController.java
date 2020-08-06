package com.github.mysql.controller;

import com.github.mysql.pojo.orm.mid.MidUserRoleDO;
import com.github.mysql.repository.IMidUserRoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 石少东
 * @date 2020-08-06 23:18
 * @since 1.0
 */

@RestController
public class MidUserRoleController {

    @Resource
    private IMidUserRoleRepository roleRepository;

    @GetMapping("mid")
    public List<MidUserRoleDO> findAll(){
        return roleRepository.findAll();
    }

}
