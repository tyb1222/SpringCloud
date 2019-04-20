package com.tyb1222.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tyb1222.api.vo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get/{name}")
    @HystrixCommand
    public User get(@PathVariable("name")String name){
        User result = new User();
        result.setName(name);
        result.setAge(5);
        return result;
    }
}
