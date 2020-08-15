package com.github.mysql.controller;


import com.github.mysql.pojo.UserInfoDO;
import com.github.mysql.pojo.UserInfoDTO;
import com.github.mysql.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
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

@Slf4j
@RestController
public class UserIndexController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("user")
    public List<UserInfoDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/users")
    public Page<String> findAll(@PageableDefault(direction = Sort.Direction.DESC, size = 4) Pageable pageable) {
        Page<UserInfoDO> page = repository.findAll(pageable);
        return page.map(UserInfoDO::getUsername);
    }

    @GetMapping("/users/condition")
    public Page<String> findAllCondition(@NotNull UserInfoDTO dto,
                                         @PageableDefault(direction = Sort.Direction.DESC, size = 4) Pageable pageable) {
        log.warn("dto:{}", dto.toString());

        Specification<UserInfoDO> specification = (Specification<UserInfoDO>) (root, criteriaQuery, criteriaBuilder) -> {
            //1.获取比较的属性
            Path<String> path1 = root.get("username");
            Path<String> path2 = root.get("password");
            //2.构造查询条件
            //     第一个参数：需要比较的属性（path对象）
            //     第二个参数：当前需要比较的取值
            //3.equal进行精准的匹配 (比较的属性，比较的属性的取值)
            Predicate predicate1 = criteriaBuilder.equal(path1, dto.getUsername());
            Predicate predicate2 = criteriaBuilder.equal(path2, dto.getRole());
            return criteriaBuilder.and(predicate1, predicate2);
        };

        Page<UserInfoDO> page = repository.findAll(pageable);
        return page.map(UserInfoDO::getUsername);
    }

//    @PostMapping("user")
//    public UserInfoDO findAll(@RequestBody UserInfoDO userIndex) {
//        return repository.save(userIndex);
//    }

}
