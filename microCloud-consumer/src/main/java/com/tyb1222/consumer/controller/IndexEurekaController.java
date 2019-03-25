package com.tyb1222.consumer.controller;

import com.tyb1222.api.vo.Product;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/indexEureka")
public class IndexEurekaController {
    private static final String PRODUCT_GET = "http://MICROCLOUD-PRODUCT-SERVER/product/get/";
    private static final String PRODUCT_ALL = "http://MICROCLOUD-PRODUCT-SERVER/product/all";
    private static final String PRODUCT_CREATE = "http://MICROCLOUD-PRODUCT-SERVER/product/create";

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
