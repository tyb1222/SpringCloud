package com.tyb1222.controller;

import com.tyb1222.api.vo.Product;
import com.tyb1222.api.vo.User;
import com.tyb1222.service.ZuulFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/zuulFeign")
public class ZuulFeignController {

    @Resource
    private ZuulFeignService service;


    @RequestMapping("/product/get")
    public Product get(Long id){
        return service.get(id);
    }

    @RequestMapping("/users/get")
    public User get( String name){
        return service.get(name);
    }
}
