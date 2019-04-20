package com.tyb1222.provider.service;

import com.tyb1222.api.vo.Product;

import java.util.List;

public interface ProductService {

    boolean create(Product product);

    public Product findById(Long id);

    public List<Product> findAll();
}
