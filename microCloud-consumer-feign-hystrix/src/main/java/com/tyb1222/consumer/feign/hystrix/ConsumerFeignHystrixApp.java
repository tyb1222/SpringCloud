package com.tyb1222.consumer.feign.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name= "MICROCLOUD-PRODUCT-SERVER")
@EnableFeignClients("com.tyb1222.consumer.feign.hystrix.service")
public class ConsumerFeignHystrixApp {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixApp.class,args);
    }
}
