package com.tyb1222.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod="getByIdFallback")
    public Product get(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        if (null == product){
            throw new RuntimeException("product not exists");
        }
        return product;
    }

    public Product getByIdFallback(@PathVariable("id") Long id){
        Product product = new Product();
        product.setProductDesc("product desc hystrix");
        product.setProductName("hystrix name hystrxi");
        product.setProductId(0L);
        return product;
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
