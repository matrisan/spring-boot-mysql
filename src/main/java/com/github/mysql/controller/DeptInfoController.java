package com.github.mysql.controller;

import com.github.mysql.pojo.DeptInfoDO;
import com.github.mysql.pojo.EmpInfoDO;
import com.github.mysql.repository.IDeptInfoRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Subquery;
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
public class DeptInfoController {

    @Resource
    private IDeptInfoRepository repository;

    @GetMapping("dept")
    public List<DeptInfoDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("dept")
    public DeptInfoDO save(@RequestBody DeptInfoDO deptInfoDO) {
        return repository.save(deptInfoDO);
    }

    @PutMapping("dept")
    public DeptInfoDO update(@RequestBody DeptInfoDO deptInfoDO) {
        return repository.save(deptInfoDO);
    }

//    @GetMapping("dept/spec")
//    public List<DeptInfoDO> findSpec() {
//        Specification<DeptInfoDO> specification = (Specification<DeptInfoDO>) (root, query, cb) -> {
//            Subquery<EmpInfoDO> subquery = query.subquery(EmpInfoDO.class);
//
//
//            Path<String> path = root.get("username");
//            return cb.like(path.as(String.class), username);
//        };
//        return repository.findAll(specification);
//    }

}
