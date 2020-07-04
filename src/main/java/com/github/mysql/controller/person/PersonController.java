package com.github.mysql.controller.person;

import com.github.mysql.pojo.orm.person.PersonDO;
import com.github.mysql.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 石少东
 * @date 2020-07-04 19:29
 * @since 1.0
 */

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final IPersonRepository repository;

    @GetMapping("person")
    public List<PersonDO> findAll() {
        return repository.findAll();
    }

}
