package com.tyb1222;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.tyb1222.service")
public class ZuulFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulFeignApp.class,args);
    }
}
