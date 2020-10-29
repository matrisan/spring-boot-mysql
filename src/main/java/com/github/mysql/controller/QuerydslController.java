package com.github.mysql.controller;

import com.github.mysql.pojo.dto.UserInfoDTO;
import com.github.mysql.pojo.orm.QUserInfoDO;
import com.github.mysql.pojo.orm.UserInfoDO;
import com.github.mysql.pojo.vo.IUserInfoVO;
import com.github.mysql.repository.IUserInfoRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-10-29 17:38
 * @since 1.0
 */

@RestController
public class QuerydslController {

    @Resource
    private IUserInfoRepository repository;

    @GetMapping("/dsl")
    public Page<UserInfoDO> query(UserInfoDTO userInfo, Pageable pageable) {
        return repository.findAll(predicate(userInfo), pageable);
    }

    @GetMapping("/dsl/web")
    public Page<UserInfoDO> queryWeb(@QuerydslPredicate(root = UserInfoDO.class) Predicate predicate, Pageable pageable) {
        return repository.findAll(predicate, pageable);
    }

    @GetMapping("/dsl/pj")
    public Page<IUserInfoVO> listAll(@QuerydslPredicate(root = UserInfoDO.class) Predicate predicate, Pageable pageable) {
        return repository.findAllBy(predicate, pageable, IUserInfoVO.class);
    }


    private Predicate predicate(UserInfoDTO userInfo) {
        QUserInfoDO qUserInfoDO = QUserInfoDO.userInfoDO;
        BooleanExpression expression = null;
        if (StringUtils.isNotBlank(userInfo.getUsername())) {
            expression = qUserInfoDO.username.startsWith(userInfo.getUsername());
        }
        if (ObjectUtils.isNotEmpty(userInfo.getAge())) {
            assert expression != null;
            expression = expression.and(qUserInfoDO.age.gt(userInfo.getAge()));
        }
        return expression;
    }


}
