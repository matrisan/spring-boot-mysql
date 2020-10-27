package com.github.mysql.pojo.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mysql.pojo.bo.GroupInfoBO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

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
@Converter(autoApply = true)
@RequiredArgsConstructor
public class GroupConverter implements AttributeConverter<GroupInfoBO, String> {

    private final ObjectMapper objectMapper;

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public String convertToDatabaseColumn(GroupInfoBO attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public GroupInfoBO convertToEntityAttribute(String dbData) {
        return objectMapper.readValue(dbData, GroupInfoBO.class);
    }
}
