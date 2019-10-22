package com.github.mysql.controller;


import com.github.mysql.pojo.DateTimeDO;
import com.github.mysql.repository.IDateTimeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

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
public class DateTimeDoController {

    @Resource
    private IDateTimeRepository repository;

    /**
     * 查询效果
     * {
     * "id": 3,
     * "date": "2019-07-03",
     * "time": "17:42:00",
     * "timestamp": "2019-07-03T09:42:00.000+0000"
     * }
     *
     * @param id id
     * @return DateTimeDO
     */
    @GetMapping("/datetime/{id}")
    public DateTimeDO get(@PathVariable Integer id) {
        Optional<DateTimeDO> optional = repository.findById(id);
        return optional.orElse(new DateTimeDO());
    }

    @PostMapping("/datetime")
    public DateTimeDO save(@RequestBody DateTimeDO dateTimeDO) {
        return repository.save(dateTimeDO);
    }

}
