package com.github.mysql.service;

import com.github.mysql.pojo.UserInfoDO;
import org.springframework.stereotype.Service;

/**
 * @author 石少东
 * @date 2020-06-18 23:38
 * @since 1.0
 */


@Service
public class UserService {

    public void print(UserInfoDO student){
        System.out.println("---------------");
    }

}
