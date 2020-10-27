package com.github.mysql.pojo.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Collections;
import java.util.List;

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
public class ListConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper objectMapper;

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return Collections.emptyList();
        }
        TypeReference<List<String>> type = new TypeReference<List<String>>() {
        };
        return objectMapper.readValue(dbData, type);
    }
}
