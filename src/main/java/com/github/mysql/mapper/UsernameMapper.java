package com.github.mysql.mapper;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 石少东
 * @date 2020-07-03 17:55
 * @since 1.0
 */


@Component
public class UsernameMapper {

    public String getUsername(String username) {
        return username + " - " + new Date().toString();
    }

}
