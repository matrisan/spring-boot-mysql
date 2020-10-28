package com.github.mysql.controller;

import com.github.mysql.pojo.orm.EmpInfoDO;
import com.github.mysql.repository.IEmpInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午4:08 2019/11/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class EmpInfoController {

    @Resource
    private IEmpInfoRepository repository;

    @GetMapping("emp")
    public List<EmpInfoDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("emp")
    public EmpInfoDO save(@RequestBody EmpInfoDO empInfoDO) {
        return repository.save(empInfoDO);
    }

    @PutMapping("emp")
    public EmpInfoDO update(@RequestBody EmpInfoDO empInfoDO) {
        return repository.save(empInfoDO);
    }


}
