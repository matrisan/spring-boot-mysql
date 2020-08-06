package com.github.mysql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-08-06 23:41
 * @since 1.0
 */


@Component
public class ObjectMapperConfig {

    @Resource
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }


}
