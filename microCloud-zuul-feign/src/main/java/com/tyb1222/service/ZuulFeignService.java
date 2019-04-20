package com.tyb1222.service;


import com.tyb1222.api.vo.Product;
import com.tyb1222.api.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("microCloud-zuul")
public interface ZuulFeignService {

    @RequestMapping("/springCloud/user-proxy/user/get/{name}")
    User get(@PathVariable("name")String name);

    @RequestMapping("/springCloud/product-proxy/get/{id}")
    Product get(@PathVariable("id") Long id);
}
