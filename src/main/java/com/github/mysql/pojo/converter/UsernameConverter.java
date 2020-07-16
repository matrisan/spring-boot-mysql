package com.github.mysql.pojo.converter;

import lombok.RequiredArgsConstructor;

import javax.persistence.AttributeConverter;

/**
 * @author 石少东
 * @date 2020-07-02 17:22
 * @since 1.0
 */

@RequiredArgsConstructor
public class UsernameConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (null == dbData) {
            return null;
        }
        return dbData + "------";
    }
}
