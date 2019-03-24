package com.tyb1222.provider.controller;

import com.tyb1222.api.vo.Product;
import com.tyb1222.provider.service.ProductService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient discoveryClient;  // Eureka服务发现

    @RequestMapping(value = "/get/{id}")
    public Product get(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @RequestMapping(value = "/get/all")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @RequestMapping(value = "/create")
    public boolean add(@RequestBody Product product){
        return productService.create(product);
    }


    @RequestMapping("/discover")
    public Object client(){
        return discoveryClient;
    }

}
