package com.github.mysql.controller;

import com.github.mysql.pojo.DeptInfoDO;
import com.github.mysql.repository.IDeptInfoRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.Path;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * <p>
 * 创建时间为 下午5:08 2020/2/16
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SpecificationController {

    @Resource
    private IDeptInfoRepository repository;

    @GetMapping("dept/spec/{name}")
    public DeptInfoDO findByName(@PathVariable String name) {
        Optional<DeptInfoDO> optional = repository.findOne((Specification<DeptInfoDO>) (root, query, builder) -> {
            Path<String> path = root.get("name");
            return builder.equal(path.as(String.class), name);
        });
        return optional.orElse(new DeptInfoDO());
    }

}
