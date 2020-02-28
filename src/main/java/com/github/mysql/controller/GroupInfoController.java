package com.github.mysql.controller;

import com.github.mysql.pojo.GroupInfoDO;
import com.github.mysql.repository.IGroupInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("group/{group_id}")
    public GroupInfoDO findById(@PathVariable("group_id") GroupInfoDO groupInfo) {
        return groupInfo;
    }

    @PostMapping("group")
    public GroupInfoDO save(@RequestBody GroupInfoDO groupInfo) {
        return repository.save(groupInfo);
    }

}
