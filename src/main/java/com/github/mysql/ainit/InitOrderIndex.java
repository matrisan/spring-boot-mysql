package com.github.mysql.ainit;

import com.github.mysql.pojo.orm.ItemDO;
import com.github.mysql.pojo.orm.OrderDO;
import com.github.mysql.repository.IOrderInfoRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * <p>
 * 创建时间为 上午11:13 2019/9/19
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
@RequiredArgsConstructor
public class InitOrderIndex {

    private final IOrderInfoRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        for (int i = 0; i < 10; i++) {
            OrderDO userInfoDO = OrderDO.builder()
                    .orderName("orderName:" + i)
                    .items(Lists.newArrayList(ItemDO.builder().itemName("item:" + i).price(i).build()))
                    .build();
            repository.save(userInfoDO);
        }
    }
}
