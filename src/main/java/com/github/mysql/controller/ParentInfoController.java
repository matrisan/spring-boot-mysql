package com.github.mysql.controller;

import com.github.mysql.pojo.OneToOneParentInfoDO;
import com.github.mysql.repository.IParentInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 21:38 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class ParentInfoController {

    @Resource
    private IParentInfoRepository repository;

    @GetMapping("/parent")
    public List<OneToOneParentInfoDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/parent/{id}")
    public OneToOneParentInfoDO getById(@PathVariable("id") int id) {
        return repository.findById(id).orElseGet(OneToOneParentInfoDO::new);
    }

    @PostMapping("/parent")
    public OneToOneParentInfoDO save(@RequestBody OneToOneParentInfoDO oneToOneParentInfoDO) {
        return repository.save(oneToOneParentInfoDO);
    }


    @PutMapping("/parent")
    public OneToOneParentInfoDO update(@RequestBody OneToOneParentInfoDO oneToOneParentInfoDO) {
        return repository.save(oneToOneParentInfoDO);
    }


}
