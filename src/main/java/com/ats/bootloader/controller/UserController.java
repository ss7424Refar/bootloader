package com.ats.bootloader.controller;

import com.ats.bootloader.domain.User;
import com.ats.bootloader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController是@ResponseBody和@Controller的组合注解。返回json
@RestController
//
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List getAllUsers() {
        List list = userService.findAllUser();
        return list;
    }

    //  http://localhost:8081/user/getUserById?userId=2
    // 请求参数为userId，不为userid
    @RequestMapping("getUserById")
    public User getUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    // localhost:8081/user/insertUser?userid=4&username=test&password=678&phone=999
    //  http://localhost:8081/user/insertUser?userid=&username=test&password=678&phone= , 可以插入null
    @RequestMapping("insertUser")
    public int insertUser(User user) {
        return userService.insertUser(user);
    }

    //  http://localhost:8081/user/insertUserSelective?userid=&username=test&password=678&phone=
    @RequestMapping("insertUserSelective")
    public int insertUserSelective(User user) {
        return userService.insertUserSelective(user);

    }
}
