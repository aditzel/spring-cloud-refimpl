package com.allanditzel.spring.cloud.ri.edgeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by tde900 on 11/23/15.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableHystrixDashboard
@EnableHystrix
public class EdgeServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EdgeServerApp.class, args);
    }
}
