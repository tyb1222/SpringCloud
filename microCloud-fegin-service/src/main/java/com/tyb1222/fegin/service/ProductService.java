package com.tyb1222.fegin.service;

import com.tyb1222.api.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "MICROCLOUD-PRODUCT-SERVER")
public interface ProductService {

    @RequestMapping(value = "/product/get/{id}")
    Product get(@PathVariable("id") Long id);

    @RequestMapping(value = "/product/get/all")
    List<Product> getAll();

    @RequestMapping(value = "/product/create")
    boolean add(@RequestBody Product product);


}
