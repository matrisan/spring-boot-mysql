package com.github.mysql.controller;

import com.github.mysql.pojo.OneToOneChildrenInfoDO;
import com.github.mysql.repository.IChildrenInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 21:40 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class ChildrenInfoController {

    @Resource
    private IChildrenInfoRepository repository;

    @GetMapping("/children/{id}")
    public OneToOneChildrenInfoDO getAddress(@PathVariable Integer id) {
        return repository.findById(id).orElseGet(OneToOneChildrenInfoDO::new);
    }

    @PostMapping("/children")
    public OneToOneChildrenInfoDO save(@RequestBody OneToOneChildrenInfoDO oneToOneChildrenInfoDO) {
        return repository.save(oneToOneChildrenInfoDO);
    }

}
