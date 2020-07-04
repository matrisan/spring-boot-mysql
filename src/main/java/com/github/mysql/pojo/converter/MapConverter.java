package com.github.mysql.pojo.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mysql.pojo.orm.person.AddressBO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import java.util.Map;

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
//@Converter(autoApply = true)
@RequiredArgsConstructor
public class MapConverter implements AttributeConverter<Map<String, AddressBO>, String> {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Map<String, AddressBO> attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public Map<String, AddressBO> convertToEntityAttribute(String dbData) {
        TypeReference<Map<String, AddressBO>> type = new TypeReference<Map<String, AddressBO>>() {
        };
        return objectMapper.readValue(dbData, type);
    }
}
