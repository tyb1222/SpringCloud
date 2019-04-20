package com.tyb1222.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class DashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApp.class,args);
    }
}
