package com.tyb1222.provider.mapper;

import com.tyb1222.api.vo.Product;

import java.util.List;

public interface ProductMapper {
    boolean create(Product product);

    Product findById(Long id);

    List<Product> findAll();
}
