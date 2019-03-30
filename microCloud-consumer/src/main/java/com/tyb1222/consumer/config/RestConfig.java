package com.tyb1222.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHeaders() {
        HttpHeaders header = new HttpHeaders();
        String headerInfo = "tyb:tyb1222";
        byte[] encodeHeaderInfo = Base64.getEncoder().encode(headerInfo.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodeHeaderInfo);
        header.set("Authorization",authHeader);
        return header;

    }




}