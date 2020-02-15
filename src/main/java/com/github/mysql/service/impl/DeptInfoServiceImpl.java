package com.github.mysql.service.impl;

import com.github.mysql.pojo.DeptInfoDO;
import com.github.mysql.repository.IDeptInfoRepository;
import com.github.mysql.service.IDeptInfoService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:12 2019/10/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class DeptInfoServiceImpl implements IDeptInfoService {

    @Resource
    private IDeptInfoRepository repository;

    @Override
    public DeptInfoDO save(DeptInfoDO deptInfoDO) {
        return repository.save(deptInfoDO);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public DeptInfoDO txSave(DeptInfoDO deptInfoDO) {
        DeptInfoDO infoDO = repository.save(deptInfoDO);
        int error = 1 / 0;
        return infoDO;
    }

//    @Override
//    public void updatePasswordByUsername(String username, String password) {
//        repository.updatePasswordByUsername(username, password);
//    }


    /**
     * root: 查询的根对象(查询的任何属性都可以从根对象中获取)
     * criteriaQuery: 顶层查询对象，自定义查询方式(了解。一般不用)
     * criteriaBuilder: 查询的构造器，封装了很多的查询条件
     *
     * @param username username
     * @return UserInfoDO
     */
    @Override
    public DeptInfoDO findByUsernameEqual(String username) {
        Specification<DeptInfoDO> specification = (Specification<DeptInfoDO>) (root, criteriaQuery, criteriaBuilder) -> {
            //1.获取比较的属性
            Path<String> path = root.get("username");
            //2.构造查询条件
            //     第一个参数：需要比较的属性（path对象）
            //     第二个参数：当前需要比较的取值
            //3.equal进行精准的匹配 (比较的属性，比较的属性的取值)
            return criteriaBuilder.equal(path, username);
        };
        return repository.findOne(specification).orElse(null);
    }

    @Override
    public DeptInfoDO findByUsernameAndPassword(String username, String password) {
        Specification<DeptInfoDO> specification = (Specification<DeptInfoDO>) (root, criteriaQuery, criteriaBuilder) -> {
            //1.获取比较的属性
            Path<String> path1 = root.get("username");
            Path<String> path2 = root.get("password");
            //2.构造查询条件
            //     第一个参数：需要比较的属性（path对象）
            //     第二个参数：当前需要比较的取值
            //3.equal进行精准的匹配 (比较的属性，比较的属性的取值)
            Predicate predicate1 = criteriaBuilder.equal(path1, username);
            Predicate predicate2 = criteriaBuilder.equal(path2, password);
            return criteriaBuilder.and(predicate1, predicate2);
        };
        return repository.findOne(specification).orElse(null);
    }


    @Override
    public List<DeptInfoDO> findAllLike(String username) {
        Specification<DeptInfoDO> specification = (Specification<DeptInfoDO>) (root, query, criteriaBuilder) -> {
            Path<String> path = root.get("username");
            return criteriaBuilder.like(path.as(String.class), username);
        };
        return repository.findAll(specification);
    }

}
