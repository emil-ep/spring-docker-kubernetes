package com.innoventes.jukebox.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterExceptionHandler extends OncePerRequestFilter {

    private static Logger logger = LoggerFactory.getLogger(FilterExceptionHandler.class);

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }catch (Exception ex){
            logger.error("Spring Security filter chain exception : {}", ex.getMessage());
            resolver.resolveException(httpServletRequest, httpServletResponse, null, ex);
        }
    }
}
