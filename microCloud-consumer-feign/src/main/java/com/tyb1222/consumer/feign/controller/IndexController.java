package com.tyb1222.consumer.feign.controller;

import com.tyb1222.api.vo.Product;
import com.tyb1222.fegin.service.ProductService;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/indexFeign")
public class IndexController {

    @Resource
    private ProductService productService;

//    @Resource
//    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get")
    public Product getProduct(Long id){
        return productService.get(id);
    }

    @RequestMapping("/product/list")
    public Object getAll(){
        return productService.getAll();
    }
}
