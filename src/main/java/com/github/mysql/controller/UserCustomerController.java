package com.github.mysql.controller;

import com.github.mysql.pojo.UserCustomerDO;
import com.github.mysql.service.IUserCustomerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午12:18 2019/11/6
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class UserCustomerController {

    @Resource
    private IUserCustomerService service;

    @PostMapping("/customer")
    public UserCustomerDO create(@RequestBody UserCustomerDO userCustomerDO) {
        return service.create(userCustomerDO);
    }

    @PutMapping("/customer")
    public UserCustomerDO update(@RequestBody UserCustomerDO userCustomerDO) {
        return service.update(userCustomerDO);

    }

    @DeleteMapping("/customer/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

}
