package com.allanditzel.spring.cloud.ri.edgeserver.filter.servlet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MaintenanceModeServletFilterTest {
    private static final String EXPECTED_MAINTENANCE_URL = "/maintenance";

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    private MaintenanceModeServletFilter filter;

    @Before
    public void setUp() throws Exception {
        filter = new MaintenanceModeServletFilter();
    }

    @Test
    public void shouldOnlyPassThroughWhenGlobalFlagDisabled() throws IOException, ServletException {
        Whitebox.setInternalState(filter, "globalMaintenanceModeEnabled", false);

        filter.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
        verifyNoMoreInteractions(request, response, filterChain);
    }

    @Test
    public void shouldNotRedirectForMaintenanceUrl() throws IOException, ServletException {
        Whitebox.setInternalState(filter, "globalMaintenanceModeEnabled", true);

        MockHttpServletRequest mockRequest = new MockHttpServletRequest("GET", EXPECTED_MAINTENANCE_URL);

        filter.doFilter(mockRequest, response, filterChain);

        verify(filterChain).doFilter(mockRequest, response);
        verifyNoMoreInteractions(response, filterChain);
    }

    @Test
    public void shouldRedirectForNonMaintenanceUrl() throws IOException, ServletException {
        Whitebox.setInternalState(filter, "globalMaintenanceModeEnabled", true);

        MockHttpServletRequest mockRequest = new MockHttpServletRequest("GET", "/webapp/");
        MockHttpServletResponse mockResponse = new MockHttpServletResponse();

        filter.doFilter(mockRequest, mockResponse, filterChain);

        assertEquals(EXPECTED_MAINTENANCE_URL, mockResponse.getRedirectedUrl());
        verifyNoMoreInteractions(filterChain);
    }
}