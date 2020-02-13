package com.github.mysql.controller;

import com.github.mysql.pojo.SystemItem;
import com.github.mysql.repository.ISystemItemRepository;
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
 * 创建时间为 下午9:26 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SystemItemController {

    @Resource
    private ISystemItemRepository repository;

    @GetMapping("item")
    public List<SystemItem> findAll() {
        return repository.findAll();
    }

    @PostMapping("item")
    public SystemItem save(@RequestBody SystemItem systemItem) {
        return repository.save(systemItem);
    }

    @PutMapping("item")
    public SystemItem update(@RequestBody SystemItem systemItem) {
        return repository.save(systemItem);
    }

    @DeleteMapping("item/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
