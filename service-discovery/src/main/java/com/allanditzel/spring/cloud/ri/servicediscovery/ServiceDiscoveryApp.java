package com.allanditzel.spring.cloud.ri.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaServer
@EnableHystrix
@EnableHystrixDashboard
public class ServiceDiscoveryApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApp.class, args);
    }
}
