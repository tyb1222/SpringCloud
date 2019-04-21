package com.tyb1222.service.fallback;

import com.tyb1222.api.vo.Product;
import com.tyb1222.api.vo.User;
import com.tyb1222.service.ZuulFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ZuulFallback implements FallbackFactory<ZuulFeignService> {
    @Override
    public ZuulFeignService create(Throwable throwable) {
        ZuulFeignService result = new ZuulFeignService() {
            @Override
            public User get(String name) {
                User user = new User();
                user.setName("zuul user name");
                user.setAge(-1);
                return user;
            }

            @Override
            public Product get(Long id) {
                Product product = new Product();
                product.setProductId(0L);
                product.setProductName("zuul product Name");
                product.setProductDesc("zuul product desc");
                return product;
            }
        };
        return result;
    }
}
