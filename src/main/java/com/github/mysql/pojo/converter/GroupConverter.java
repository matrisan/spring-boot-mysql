package com.github.mysql.pojo.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mysql.pojo.bo.GroupInfoBO;
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
public class GroupConverter implements AttributeConverter<GroupInfoBO, String> {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(GroupInfoBO attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public GroupInfoBO convertToEntityAttribute(String dbData) {
        return objectMapper.readValue(dbData, GroupInfoBO.class);
    }
}
