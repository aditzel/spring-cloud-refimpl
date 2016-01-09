package com.allanditzel.spring.cloud.ri.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Allan on 1/9/2016.
 */
@EnableHystrixDashboard
@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
public class WebappApp {
    public static void main(String[] args) {
        SpringApplication.run(WebappApp.class, args);
    }
}
