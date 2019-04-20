package com.tyb1222.config;

import com.tyb1222.filter.AuthorizedRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
    @Bean
    public AuthorizedRequestFilter getAuthorizeRequestFilter(){
        return new AuthorizedRequestFilter();
    }
}
