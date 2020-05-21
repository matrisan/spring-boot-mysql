package com.github.mysql.pojo.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;

/**
 * <p>
 * 创建时间为 下午7:02 2020/5/21
 * 项目名称 spring-boot-mysql
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RequiredArgsConstructor
public class MobileConverter implements AttributeConverter<String, String> {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return objectMapper.writeValueAsString(":convertToDatabaseColumn:" + attribute);

    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return ":convertToEntityAttribute:" + dbData;
    }
}
