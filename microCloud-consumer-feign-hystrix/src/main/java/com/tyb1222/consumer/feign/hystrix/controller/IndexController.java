package com.tyb1222.consumer.feign.hystrix.controller;

import com.tyb1222.api.vo.Product;
import com.tyb1222.consumer.feign.hystrix.service.ProductService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/indexFeignHystrix")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class IndexController {
    @Resource
    private ProductService productService;

    @RequestMapping("/get")
    public Product getProduct(Long id){
        return productService.get(id);
    }
}
