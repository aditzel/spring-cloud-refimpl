package com.allanditzel.spring.cloud.ri.edgeserver.filter.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MaintenanceModeServletFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(MaintenanceModeServletFilter.class);
    private static final String MAINTENANCE_MODE_URL = "/maintenance";

    @Value("${maintenance.global.enabled}")
    private boolean globalMaintenanceModeEnabled;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (globalMaintenanceModeEnabled && shouldRedirect((HttpServletRequest) servletRequest)) {
            log.info("GLOBAL maintenance mode enabled, redirecting to: {}", MAINTENANCE_MODE_URL);
            ((HttpServletResponse)servletResponse).sendRedirect(MAINTENANCE_MODE_URL);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean shouldRedirect(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        boolean shouldRedirect = !MAINTENANCE_MODE_URL.equals(requestUri);
        log.info("Processing URL {}. Should redirect? {}", requestUri, shouldRedirect);

        return shouldRedirect;
    }
}
