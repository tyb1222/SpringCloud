package com.tyb1222.provider.service.impl;

import com.tyb1222.api.vo.Product;
import com.tyb1222.provider.mapper.ProductMapper;
import com.tyb1222.provider.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean create(Product product) {
        return productMapper.create(product);
    }

    @Override
    public Product findById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }
}
