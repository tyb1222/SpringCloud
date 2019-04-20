package com.tyb1222.fegin.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
//    @Bean
//    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
//        return new BasicAuthRequestInterceptor("tyb","tyb1222");
//    }

//    @Bean
//    public Logger.Level getFeignLogLevel(){
//        return Logger.Level.FULL;
//    }
}
