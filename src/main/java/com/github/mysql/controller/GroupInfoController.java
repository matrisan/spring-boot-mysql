package com.github.mysql.controller;

import com.github.mysql.pojo.orm.GroupInfoDO;
import com.github.mysql.repository.IGroupInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午2:23 2020/2/28
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class GroupInfoController {

    @Resource
    private IGroupInfoRepository repository;

    @GetMapping("all")
    public List<GroupInfoDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("group/{id}")
    public GroupInfoDO findById(@PathVariable("id") GroupInfoDO groupInfo) {
        return groupInfo;
    }

    @GetMapping("groups/{id}")
    public Set<GroupInfoDO> findById(@PathVariable("id") Set<GroupInfoDO> groupInfos) {
        return groupInfos;
    }

    @PostMapping("group")
    public GroupInfoDO save(@RequestBody GroupInfoDO groupInfo) {
        return repository.save(groupInfo);
    }

}
