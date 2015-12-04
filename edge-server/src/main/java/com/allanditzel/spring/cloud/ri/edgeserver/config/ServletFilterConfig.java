package com.allanditzel.spring.cloud.ri.edgeserver.config;

import com.allanditzel.spring.cloud.ri.edgeserver.filter.servlet.MaintenanceModeServletFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletFilterConfig {

    @Bean
    public MaintenanceModeServletFilter maintenanceModeServletFilter() {
        return new MaintenanceModeServletFilter();
    }
}
