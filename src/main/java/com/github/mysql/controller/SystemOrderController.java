package com.github.mysql.controller;

import com.github.mysql.pojo.SystemOrder;
import com.github.mysql.repository.ISystemOrderRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
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
 * 创建时间为 下午9:27 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SystemOrderController {

    @Resource
    private ISystemOrderRepository repository;

    @GetMapping("order")
    public List<SystemOrder> findAll() {
        return repository.findAll();
    }

    @PostMapping("order")
    public SystemOrder save(@RequestBody SystemOrder systemOrder) {
        return repository.save(systemOrder);
    }

    @PutMapping("order")
    public SystemOrder update(@RequestBody SystemOrder systemOrder) {
        return repository.save(systemOrder);
    }

    @DeleteMapping("order/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
