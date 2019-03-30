package com.tyb1222.consumer.controller;

import com.tyb1222.api.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

@RestController
@RequestMapping("/indexRibbon")
public class IndexRibbonController {
    private static final String PRODUCT_TOPIC ="MICROCLOUD-PRODUCT-SERVER";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(PRODUCT_TOPIC);
        URI uri = URI.create(String.format("http://%s:%s/product/get/",serviceInstance.getHost(),serviceInstance.getPort()));
        Object product = restTemplate.exchange(uri + String.valueOf(id),
                HttpMethod.GET, new HttpEntity<Product>(httpHeaders), Product.class).getBody();
        return product;
    }

    @RequestMapping("/product/all")
    public Object getAllProduct() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(PRODUCT_TOPIC);
        URI uri = URI.create(String.format("http://%s:%s/get/all", serviceInstance.getHost(), serviceInstance.getPort()));
        Object result = restTemplate.getForEntity(uri, Product.class);
        return result;
    }

}
