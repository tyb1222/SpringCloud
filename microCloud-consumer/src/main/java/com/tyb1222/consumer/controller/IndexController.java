package com.tyb1222.consumer.controller;

import com.tyb1222.api.vo.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/index")
public class IndexController {
    private static final String PRODUCT_GET = "http://127.0.0.1:8080/product/get/";
    private static final String PRODUCT_ALL = "http://127.0.0.1:8080/product/all";
    private static final String PRODUCT_CREATE = "http://127.0.0.1:8080/product/create";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Object product = restTemplate.exchange(PRODUCT_GET + id,
                HttpMethod.GET, new HttpEntity<Product>(httpHeaders), Product.class).getBody();
        return product;
    }

    @RequestMapping("/product/all")
    public Object getAllProduct() {
        Object result = restTemplate.getForEntity(PRODUCT_ALL, Product.class);
        return result;
    }

    @RequestMapping("/product/add")
    public boolean add(Product product) {
        return restTemplate.postForObject(PRODUCT_CREATE, product, Boolean.class);
    }
}
