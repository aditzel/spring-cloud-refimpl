package com.allanditzel.spring.cloud.ri.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApp.class, args);
    }
}
