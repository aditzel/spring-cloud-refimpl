package com.allanditzel.spring.cloud.ri.edgeserver;

import com.allanditzel.spring.cloud.ri.edgeserver.config.ServletFilterConfig;
import com.allanditzel.spring.cloud.ri.edgeserver.config.ZuulFilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by tde900 on 11/23/15.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableHystrixDashboard
@EnableHystrix
@EnableAutoConfiguration
@Import({
        ServletFilterConfig.class,
        ZuulFilterConfig.class
})
public class EdgeServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EdgeServerApp.class, args);
    }
}
