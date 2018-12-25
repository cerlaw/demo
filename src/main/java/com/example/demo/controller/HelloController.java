package com.example.demo.controller;

import com.example.demo.module.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghongjie
 * @date 2018/12/11
 * @descrition
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("晓琳");
        user.setUserPwd("xxxxxx");
        return user;
    }
}
