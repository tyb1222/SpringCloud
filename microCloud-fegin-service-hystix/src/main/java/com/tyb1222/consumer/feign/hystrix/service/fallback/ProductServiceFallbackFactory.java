package com.tyb1222.consumer.feign.hystrix.service.fallback;

import com.tyb1222.api.vo.Product;
import com.tyb1222.consumer.feign.hystrix.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public Product get(Long id) {
                Product result = new Product();
                result.setProductDesc("product desc fallback");
                result.setProductName("product name fallback");
                result.setProductId(999999999L);
                return result;
            }
            @Override
            public List<Product> getAll() {
                return null;
            }

            @Override
            public boolean add(Product product) {
                return false;
            }
        };
    }
}
