package com.github.mysql.ainit.person;

import com.github.mysql.pojo.orm.person.AddressBO;
import com.github.mysql.pojo.orm.person.PersonDO;
import com.github.mysql.repository.IPersonRepository;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-07-04 19:31
 * @since 1.0
 */

@Component
@RequiredArgsConstructor
public class InitPerson {

    private final IPersonRepository repository;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Map<String, AddressBO> map = Maps.newHashMap();
            AddressBO address = AddressBO.builder()
                    .address(RandomStringUtils.randomAlphabetic(6))
                    .random(RandomStringUtils.randomAlphabetic(6))
                    .date(new Date())
                    .build();
            map.put(i + "", address);
            PersonDO person = PersonDO.builder().address(map).build();
            repository.save(person);
        }
    }

}
