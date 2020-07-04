package com.github.mysql.controller.user;

import com.github.mysql.pojo.orm.user.RoleInfoDO;
import com.github.mysql.pojo.vo.RoleInfoVO;
import com.github.mysql.repository.IRoleInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午8:43 2020/2/13
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class RoleInfoController {

    @Resource
    private IRoleInfoRepository repository;

    @GetMapping("role")
    public Page<RoleInfoVO> findAll(@PageableDefault Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    @PostMapping("role")
    public RoleInfoDO save(@RequestBody RoleInfoDO roleInfo) {
        return repository.save(roleInfo);
    }

}
