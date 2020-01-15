package com.github.mysql.controller;


import com.github.mysql.pojo.TemporalTypeDO;
import com.github.mysql.repository.ITemporalTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 17:38 2019-07-03
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class TemporalTypeController {

    @Resource
    private ITemporalTypeRepository repository;

    @GetMapping("/datetimes")
    public List<TemporalTypeDO> getAll() {
        return repository.findAll();
    }


    /**
     * 查询效果
     * {
     * "id": 3,
     * "date": "2019-07-03",
     * "time": "17:42:00",
     * "timestamp": "2019-07-03T09:42:00.000+0000"
     * }
     *
     * @param dateTime dateTime
     * @return DateTimeDO
     */
    @GetMapping("/datetime/{id}")
    public TemporalTypeDO get(@PathVariable("id") TemporalTypeDO dateTime) {
        return dateTime;
    }

    @PostMapping("/datetime")
    public TemporalTypeDO save(@RequestBody TemporalTypeDO temporalTypeDO) {
        return repository.save(temporalTypeDO);
    }

}
