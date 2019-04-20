package com.tyb1222.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class Authorized {

    @Bean
    public HttpHeaders getHttpHeader(){
        HttpHeaders header = new HttpHeaders();
        String authInfo = "tyb:1";
        byte[] bytes = Base64.getEncoder().encode(authInfo.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(bytes);
        header.set("Authorization",authHeader);
        return header;
//        HttpHeaders header = new HttpHeaders();
//        String headerInfo = "tyb:1";
//        byte[] encodeHeaderInfo = Base64.getEncoder().encode(headerInfo.getBytes(Charset.forName("US-ASCII")));
//        String authHeader = "Basic " + new String(encodeHeaderInfo);
//        header.set("Authorization",authHeader);
//        return header;
    }
}
