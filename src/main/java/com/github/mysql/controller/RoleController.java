package com.github.mysql.controller;

import com.github.mysql.pojo.ManyToManyRoleDO;
import com.github.mysql.repository.ISystemRoleRepository;
import com.github.mysql.repository.ISystemUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
 * 创建时间为 下午9:19 2020/2/9
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class RoleController {

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemRoleRepository roleRepository;

    @GetMapping("roles/{userId}")
    public Page<ManyToManyRoleDO> findAllRoles(@PathVariable Long userId,
                                               @PageableDefault(direction = Sort.Direction.DESC, size = 4, sort = "createDate") Pageable pageable) {
        return userRepository.findAllRole(userId, pageable);
    }

    @GetMapping("roles")
    public List<ManyToManyRoleDO> findAll() {
        return roleRepository.findAll();
    }

    @PostMapping("role")
    public ManyToManyRoleDO save(@RequestBody ManyToManyRoleDO manyRole) {
        return roleRepository.save(manyRole);
    }

    @PutMapping("role")
    public ManyToManyRoleDO update(@RequestBody ManyToManyRoleDO manyRole) {
        return roleRepository.save(manyRole);
    }

    @DeleteMapping("role/{roleId}")
    public String delete(@PathVariable long roleId) {
        roleRepository.deleteById(roleId);
        return "删除数据";
    }

}
