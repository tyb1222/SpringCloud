package com.tyb1222.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@RibbonClient(configuration = RibbonConfig.class,name = "MICROCLOUD-PRODUCT-SERVER")
public class ConsumerAppRibbon {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppRibbon.class,args);
    }
}
