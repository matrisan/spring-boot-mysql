//package com.github.mysql.controller;
//
//
//import com.github.mysql.pojo.UserInfoDO;
//import com.github.mysql.repository.IUserDoRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Optional;
//
///**
// * <p>
// * 创建时间为 15:55 2019-07-03
// * 项目名称 spring-boot-mysql
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@RestController
//public class UserDoController {
//
//    @Resource
//    private IUserDoRepository repository;
//
//    @GetMapping("/user/{id}")
//    public UserInfoDO getUser(@PathVariable Integer id) {
//        Optional<UserInfoDO> optional = repository.findById(id);
//        return optional.orElse(new UserInfoDO());
//    }
//
//    @GetMapping("/users")
//    public Page<UserInfoDO> getUsers(@PageableDefault(size = 4, page = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//        return repository.findAll(pageable);
//    }
//
//    @PostMapping("/user")
//    public UserInfoDO saveUser(@RequestBody UserInfoDO userInfoDO) {
//        return repository.save(userInfoDO);
//    }
//
//}
