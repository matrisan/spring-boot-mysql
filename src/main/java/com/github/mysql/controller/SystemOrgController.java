package com.github.mysql.controller;

import com.github.mysql.pojo.SystemOrgDO;
import com.github.mysql.repository.ISystemOrgRepository;
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
 * 创建时间为 上午11:00 2020/2/17
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SystemOrgController {

    @Resource
    private ISystemOrgRepository repository;

    @GetMapping("org")
    public List<SystemOrgDO> findAll(){
        return repository.findAll();
    }

    @GetMapping("org/{org_id}")
    public SystemOrgDO findById(@PathVariable SystemOrgDO systemOrg) {
        return systemOrg;
    }

    @PostMapping("org")
    public SystemOrgDO save(@RequestBody SystemOrgDO systemOrg){
        return repository.save(systemOrg);
    }

    @PutMapping("org")
    public SystemOrgDO update(@RequestBody SystemOrgDO systemOrg){
        return repository.save(systemOrg);
    }

    @DeleteMapping("org/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }

}
